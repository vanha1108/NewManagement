package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.paging.PageRequest;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.IUserService;
import ha.hoclaptrinhweb.sort.Sorter;
import ha.hoclaptrinhweb.utils.FormUtil;
import ha.hoclaptrinhweb.utils.MessageUtil;
import ha.hoclaptrinhweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        String viewPath = "";

        if (userModel.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(userModel.getPage(), userModel.getMaxPageItem(), new Sorter(userModel.getSortName(), userModel.getSortBy()));
            userModel.setListResult(userService.findAll());
            userModel.setTotalItem(userService.getTotalItem());
            userModel.setTotalPage((int) Math.ceil((double) userModel.getTotalItem() / userModel.getMaxPageItem()));
            viewPath = "views/admin/user/list.jsp";
        } else if (userModel.getType().equals(SystemConstant.ADD)) {
            viewPath = "views/admin/user/edit.jsp";
        } else if (userModel.getType().equals(SystemConstant.EDIT)) {
            if (userModel.getId() != 0L) {
                userModel = userService.findById(userModel.getId());
            }
            viewPath = "views/admin/user/edit.jsp";
        } else if (userModel.getType().equals(SystemConstant.DELETE)) {
            if (userModel.getId() != null) {
                UserModel findUser = userService.findById(userModel.getId());
                if (findUser != null) {
                    userService.delete(userModel.getId());
                }
                userModel.setListResult(userService.findAll());
            }
            viewPath = "views/admin/user/list.jsp";
        }
        MessageUtil.showMessage(req);
        req.setAttribute(SystemConstant.MODEL, userModel);

        UserModel findRole = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
        req.setAttribute(SystemConstant.ROLE, findRole.getRole().getName());

        RequestDispatcher rd = req.getRequestDispatcher(viewPath);

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        UserModel userCurrent = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
        String viewPath = "";

        String strId = req.getParameter("id");
        Long id = -1L;
        if (strId != null) {
            id = Long.parseLong(strId);
        }

        if (id != -1) {
            UserModel userUpdate = userService.findById(id);
            if (userUpdate != null) {
                userUpdate.setFullName(userModel.getFullName());
                userUpdate.setPassword(userModel.getPassword());
                userUpdate.setModifiedBy(userCurrent.getUserName());
                userService.update(userUpdate);
            }
        } else {
            UserModel checkName = userService.findByUserName(userModel.getUserName());
            if (checkName == null) {
                UserModel userNew = new UserModel();
                userNew.setUserName(userModel.getUserName());
                userNew.setFullName(userModel.getFullName());
                userNew.setPassword(userModel.getPassword());
                userNew.setStatus(1);
                userNew.setRoleId(2L);
                userNew.setCreatedBy(userCurrent.getUserName());
                userService.save(userNew);
            }
        }

        userModel.setListResult(userService.findAll());
        viewPath = "views/admin/user/list.jsp";

        MessageUtil.showMessage(req);
        req.setAttribute(SystemConstant.MODEL, userModel);
        RequestDispatcher rd = req.getRequestDispatcher(viewPath);

        rd.forward(req, resp);
    }
}
