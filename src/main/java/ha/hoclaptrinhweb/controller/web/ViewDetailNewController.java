package ha.hoclaptrinhweb.controller.web;

import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.PageRequest;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.ICategoryService;
import ha.hoclaptrinhweb.service.INewService;
import ha.hoclaptrinhweb.sort.Sorter;
import ha.hoclaptrinhweb.utils.FormUtil;

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

@WebServlet(urlPatterns = {"/chi-tiet"})
public class ViewDetailNewController extends HttpServlet {
    @Inject
    private INewService newService;

    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewModel model = FormUtil.toModel(NewModel.class, req);
        String viewPath = "";

        //Load data for category
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
        req.setAttribute("topCategory", topCategory);
        req.setAttribute("childCategory", categoryChildList);
        //End load category

        //Load detail
        newService.upViewClick(model.getId());
        NewModel detail = newService.findOne(model.getId());

        if(detail != null){
            detail.setCategoryName(categoryService.findOne(detail.getCategoryId()).getName());

            req.setAttribute("detailNew",detail);

            viewPath = "/views/web/view-detail.jsp";
        }else {
            viewPath = "/views/web/home.jsp";
        }


        //Load topview
        List<NewModel> topNews = newService.findTopView(2);
        req.setAttribute("topNew", topNews);

        RequestDispatcher rd = req.getRequestDispatcher(viewPath);
        rd.forward(req, resp);
    }
}
