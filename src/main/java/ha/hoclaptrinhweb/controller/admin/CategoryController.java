package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.CategoryModel;
import ha.hoclaptrinhweb.paging.PageRequest;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.ICategoryService;
import ha.hoclaptrinhweb.sort.Sorter;
import ha.hoclaptrinhweb.utils.FormUtil;
import ha.hoclaptrinhweb.utils.MessageUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/admin-category" })
public class CategoryController extends HttpServlet {
    @Inject
    private ICategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryModel categoryModel = FormUtil.toModel(CategoryModel.class,req);
        String viewPath ="";


        if(categoryModel.getType().equals(SystemConstant.LIST)){
//            Pageble pageble = new PageRequest(categoryModel.getPage(), categoryModel.getMaxPageItem(),  new Sorter(categoryModel.getSortName(), categoryModel.getSortBy()));
            categoryModel.setListResult(categoryService.findAll());
            categoryModel.setTotalItem(categoryService.getTotalItem());
//            categoryModel.setTotalPage((int) Math.ceil((double) categoryModel.getTotalItem() / categoryModel.getMaxPageItem()));
            viewPath = "views/admin/category/list.jsp";
        }else if(categoryModel.getType().equals(SystemConstant.ADD)){
            viewPath = "views/admin/category/edit.jsp";
        } else if(categoryModel.getType().equals(SystemConstant.EDIT)) {
            if(!categoryModel.getId().equals("")){
                categoryModel = categoryService.findOne(categoryModel.getId());
            }
            viewPath = "views/admin/category/edit.jsp";
        }else if(categoryModel.getType().equals(SystemConstant.DELETE)){
            if(!categoryModel.getId().equals("")){
                CategoryModel findCategory = categoryService.findOne(categoryModel.getId());
                if(findCategory != null){
                    categoryService.delete(categoryModel.getId());
                }

                categoryModel.setListResult(categoryService.findAll());
                categoryModel.setTotalItem(categoryService.getTotalItem());
            }

            viewPath = "views/admin/category/list.jsp";
        }else if(categoryModel.getType().equals(SystemConstant.UPDATE)) {
            //Kiểm tra id có trong hệ thống
            Long id = Long.parseLong(req.getParameter("id"));
            String name =  req.getParameter("name");

            if(name != ""){
                CategoryModel categoryCheck = categoryService.findOne(id);
                CategoryModel categoryName = categoryService.findByName(name);
                if(categoryCheck != null && categoryName ==null){
                    categoryCheck.setName(name);
                    categoryService.update(categoryCheck);
                }

                categoryModel.setListResult(categoryService.findAll());
                categoryModel.setTotalItem(categoryService.getTotalItem());
                viewPath = "views/admin/category/list.jsp";
            }
        }else if (categoryModel.getType().equals(SystemConstant.ADD)){
            String name =  req.getParameter("name");

            if(name != "") {
                CategoryModel categoryName = categoryService.findByName(name);
                if(categoryName == null){
                    CategoryModel catego = new CategoryModel();
                    catego.setName(name);
                    catego.setCount_use(0);
                    categoryService.save(catego);
                }

                categoryModel.setListResult(categoryService.findAll());
                categoryModel.setTotalItem(categoryService.getTotalItem());
                viewPath = "views/admin/category/list.jsp";
            }
        }

        MessageUtil.showMessage(req);
        req.setAttribute(SystemConstant.MODEL, categoryModel);
        RequestDispatcher rd = req.getRequestDispatcher(viewPath);

        rd.forward(req, resp);
    }
}
