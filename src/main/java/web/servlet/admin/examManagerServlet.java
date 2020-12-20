package web.servlet.admin;

import domain.Exam;
import domain.PageBean;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/examManagerServlet")
public class examManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        AdminService adminService = new AdminServiceImpl();
        PageBean<Exam> pb = adminService.findExamByPage(currentPage, rows);
        request.setAttribute("pb", pb);
        request.getRequestDispatcher("jsp/admin/cleanExam.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
