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

@WebServlet(urlPatterns = {"/danh-muc"})
public class ViewByCategoryController extends HttpServlet {
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

        int page = 1;

        if(model.getPage() != null){
            if(model.getPage() != 1 && model.getPage()>0){
                page = model.getPage();
            }
        }
        Pageble pageble = new PageRequest(page, 10,new Sorter("createddate","desc"));

        List<NewModel> newModelList = newService.findByCategory(model.getId(), pageble);
        CategoryModel category = categoryService.findOne(model.getId());

        if (category != null) {
            model.setCategoryName(category.getName());
        }

        model.setListResult(newModelList);
        model.setTotalItem(newModelList.size());
        model.setTotalPage(newModelList.size() / 10);

        req.setAttribute("model", model);


        //Load topview
        List<NewModel> topNews = newService.findTopView(2);
        req.setAttribute("topNew", topNews);

        viewPath = "/views/web/view-by-category.jsp";
        RequestDispatcher rd = req.getRequestDispatcher(viewPath);
        rd.forward(req, resp);
    }
}
