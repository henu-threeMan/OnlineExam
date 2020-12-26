package web.servlet.admin;

import domain.Admin;
import domain.Teacher;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteTeacherServlet")
public class deleteTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AdminService adminService = new AdminServiceImpl();
        Teacher teacher = adminService.findTeacherById(id);
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        adminService.delTeacher(id);
        if (teacher.getUsername().equals(admin.getUsername())) {
            request.setAttribute("login_msg", "该账户已删除，请重新登录！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/teacherManagerServlet?currentPage=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
