package web.servlet.teacher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addNotificationServlet")
public class AddNotificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newNotification = request.getParameter("newNotification");
        List<String> notificationList;
        ServletContext servletContext = this.getServletContext();
        if (servletContext.getAttribute("notificationList") == null) {
            notificationList = new ArrayList<String>();
        } else {
            notificationList = (List<String>) servletContext.getAttribute("notificationList");
        }
        notificationList.add(newNotification);
        servletContext.setAttribute("notificationList", notificationList);
        response.sendRedirect("jsp/teacher/notificationManager.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
