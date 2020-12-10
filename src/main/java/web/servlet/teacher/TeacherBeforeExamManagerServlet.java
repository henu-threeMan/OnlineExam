package web.servlet.teacher;

import domain.Exam;
import domain.PageBean;
import domain.Teacher;
import service.AdminService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacherBeforeExamManagerServlet")
public class TeacherBeforeExamManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        String username = request.getParameter("username");

        TeacherService teacherService = new TeacherServiceImpl();
        PageBean<Exam> pb = teacherService.findTeacherByPage(currentPage, rows);
        Teacher teacher = teacherService.findTeacherByUsername(username);

        request.setAttribute("pb", pb);
        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("/jsp/teacher/beforeExam.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
