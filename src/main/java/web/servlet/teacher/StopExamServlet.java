package web.servlet.teacher;

import domain.Exam;
import domain.PageBean;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stopExamServlet")
public class StopExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        TeacherService teacherService = new TeacherServiceImpl();
        teacherService.stopExam(id);
        this.getServletContext().removeAttribute("startingExam");

        response.sendRedirect(request.getContextPath() + "/teacherAfterExamManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
