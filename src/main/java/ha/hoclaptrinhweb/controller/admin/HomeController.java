package ha.hoclaptrinhweb.controller.admin;

import ha.hoclaptrinhweb.constant.SystemConstant;
import ha.hoclaptrinhweb.model.UserModel;
import ha.hoclaptrinhweb.utils.SessionUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 7364772432607070424L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");

		request.setAttribute(SystemConstant.ROLE, userModel.getRole().getName());

		RequestDispatcher rd = request.getRequestDispatcher("views/admin/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
