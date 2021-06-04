package ha.hoclaptrinhweb.controller.web;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.paging.PageRequest;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.ICategoryService;
import ha.hoclaptrinhweb.service.INewService;
import ha.hoclaptrinhweb.service.IUserService;
import ha.hoclaptrinhweb.sort.Sorter;
import ha.hoclaptrinhweb.utils.FormUtil;
import ha.hoclaptrinhweb.utils.SessionUtil;

import javax.enterprise.inject.New;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {

    private static final long serialVersionUID = 7364772432607070424L;

    @Inject
    private IUserService userService;

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String message = request.getParameter("message");
        String alert = request.getParameter("alert");

        if (message != null && alert != null) {
            request.setAttribute("message", resourceBundle.getString(message));
            request.setAttribute("alert", alert);
        }

        if (action != null && action.equals("login")) {
            RequestDispatcher rd = request.getRequestDispatcher("views/login/login.jsp");
            rd.forward(request, response);
        } else if (action != null && action.equals("logout")) {
            SessionUtil.getInstance().removeValue(request, "USERMODEL");
            response.sendRedirect(request.getContextPath() + "/trang-chu");
        } else {

            //Load category
            List<CategoryModel> topCategory = categoryService.findAll();
            List<CategoryModel> categoryChildList = new ArrayList<>();
            CategoryModel categoryDropdown = new CategoryModel();

            if (topCategory.size() > 9) {
                for (int i = 9; i < topCategory.size(); i++) {
                    categoryChildList.add(topCategory.get(i));
                }


                while (topCategory.size() > 9) {
                    topCategory.remove(9);
                }
            }
            request.setAttribute("topCategory", topCategory);
            request.setAttribute("childCategory", categoryChildList);

            //Load tin tức
            NewModel model = FormUtil.toModel(NewModel.class, request);
            int page = 1;
            if(model.getPage() != 1 && model.getPage()>0){
                page = model.getPage();
            }
            Pageble pageble = new PageRequest(page, 10,new Sorter("createddate","desc"));

            List<NewModel> newModels = newService.findAll(pageble);
            for (NewModel newModel: newModels) {
                newModel.setCategoryName(categoryService.findOne(newModel.getCategoryId()).getName());
            }

            model.setListResult(newModels);
            model.setTotalItem(newService.getTotalItem());
            model.setMaxPageItem(10);

            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			request.setAttribute("listNew", model.getListResult());

			List<NewModel> topNews = newService.findTopView(2);
			request.setAttribute("topNew",topNews);

            RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
        String action = request.getParameter("action");
        if (action != null && action.equals("login")) {
            UserModel model = FormUtil.toModel(UserModel.class, request);
            model = userService.findByUsernameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
            if (model != null) {
                SessionUtil.getInstance().putValue(request, "USERMODEL", model);

                if (model.getRole().getName().equals(SystemConstant.USER)) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                } else if (model.getRole().getName().equals(SystemConstant.ADMIN)) {
                    response.sendRedirect(request.getContextPath() + "/admin-home");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=login_invalid&alert=danger");
            }
        }
    }

}
