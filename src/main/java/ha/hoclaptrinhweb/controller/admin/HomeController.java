package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.service.ICategoryService;
import ha.hoclaptrinhweb.service.INewService;
import ha.hoclaptrinhweb.service.IUserService;
import ha.hoclaptrinhweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 7364772432607070424L;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;

    @Inject
    private IUserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");

        int totalCategory = categoryService.getTotalItem();
        int totalNew = newService.getTotalItem();
        int totalUser = userService.getTotalItem();

        request.setAttribute(SystemConstant.ROLE, userModel.getRole().getName());
        request.setAttribute("totalCategory", totalCategory);
        request.setAttribute("totalNew", totalNew);
        request.setAttribute("totalUser", totalUser);

        RequestDispatcher rd = request.getRequestDispatcher("views/admin/home.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
