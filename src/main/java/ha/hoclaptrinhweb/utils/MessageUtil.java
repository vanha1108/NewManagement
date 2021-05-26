package ha.hoclaptrinhweb.utils;

import ha.hoclaptrinhweb.constant.SystemConstant;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
    public static void showMessage(HttpServletRequest request) {
        if ( request.getParameter("message") != null ) {
            String messageParam = request.getParameter("message");
            String message = "";
            String alert="";
            if (messageParam.equals("insert_success")) {
                message = SystemConstant.insert_success;
                alert = "success";
            } else if(messageParam.equals("update_success")) {
                message = SystemConstant.update_success;
                alert = "success";
            } else if (messageParam.equals("delete_success")) {
                message = SystemConstant.delete_success;
                alert = "success";
            } else if (messageParam.equals("error_system")) {
                message = SystemConstant.error_system;
                alert = "danger";
            }
            request.setAttribute("messageParam", message);
            request.setAttribute("alert", alert);
        }
    }
}
