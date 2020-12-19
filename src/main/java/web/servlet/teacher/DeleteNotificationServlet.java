package web.servlet.teacher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteNotificationServlet")
public class DeleteNotificationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        ServletContext servletContext = this.getServletContext();
        List<String> notificationList = (List<String>) servletContext.getAttribute("notificationList");
        notificationList.remove(index);
        servletContext.setAttribute("notificationList", notificationList);
        response.sendRedirect("jsp/teacher/notificationManager.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
