package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.CategoryModel;
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
    private  IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel userModel = FormUtil.toModel(UserModel.class, req);
        String viewPath ="";

        if (userModel.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(userModel.getPage(), userModel.getMaxPageItem(),new Sorter(userModel.getSortName(), userModel.getSortBy()));
            userModel.setListResult(userService.findAll(pageble));
            userModel.setTotalItem(userService.getTotalItem());
            userModel.setTotalPage((int) Math.ceil((double) userModel.getTotalItem() / userModel.getMaxPageItem()));

            viewPath = "views/admin/user/list.jsp";
        }

        MessageUtil.showMessage(req);
        req.setAttribute(SystemConstant.MODEL, userModel);

        UserModel findRole = (UserModel) SessionUtil.getInstance().getValue(req,"USERMODEL");
        req.setAttribute(SystemConstant.ROLE, findRole.getRole().getName());

        RequestDispatcher rd = req.getRequestDispatcher(viewPath);

        rd.forward(req, resp);
    }
}
