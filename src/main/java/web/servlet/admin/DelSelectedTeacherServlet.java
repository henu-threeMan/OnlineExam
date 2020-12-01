package web.servlet.admin;

import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedTeacherServlet")
public class DelSelectedTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] tids = request.getParameterValues("tid");
        for (String tid : tids) {
            System.out.println(tid);
        }

        AdminService adminService = new AdminServiceImpl();
        adminService.delSelectedTeachers(tids);


        response.sendRedirect(request.getContextPath() + "/teacherManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
