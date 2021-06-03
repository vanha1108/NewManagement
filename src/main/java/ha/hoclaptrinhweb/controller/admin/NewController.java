package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.NewModel;
import ha.hoclaptrinhweb.paging.PageRequest;
import ha.hoclaptrinhweb.paging.Pageble;
import ha.hoclaptrinhweb.service.ICategoryService;
import ha.hoclaptrinhweb.service.INewService;
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

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

    private static final long serialVersionUID = 4843647429540401582L;

    @Inject
    private INewService newService;

    @Inject
    private ICategoryService categoryService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewModel model = FormUtil.toModel(NewModel.class, request);
        String viewPath = "";
        if (model.getType().equals(SystemConstant.LIST)) {
            Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
            model.setListResult(newService.findAll(pageble));
            model.setTotalItem(newService.getTotalItem());
            model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
            viewPath = "views/admin/new/list.jsp";

        } else if (model.getType().equals(SystemConstant.EDIT)) {
            if (model.getId() != null) {
                if (model.getId() != null) {
                    model = newService.findOne(model.getId());
                }
            }
            request.setAttribute("categories", categoryService.findAll());
            viewPath = "views/admin/new/edit.jsp";
        }
        MessageUtil.showMessage(request);
        request.setAttribute(SystemConstant.MODEL, model);
        RequestDispatcher rd = request.getRequestDispatcher(viewPath);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
