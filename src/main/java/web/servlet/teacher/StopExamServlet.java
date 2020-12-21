package web.servlet.teacher;

import domain.Exam;
import domain.PageBean;
import domain.Teacher;
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
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        TeacherService teacherService = new TeacherServiceImpl();
        teacherService.stopExam(id);
        this.getServletContext().removeAttribute(teacher.getUsername());
        response.sendRedirect(request.getContextPath() + "/teacherAfterExamManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
