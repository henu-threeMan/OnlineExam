package web.servlet.teacher;

import domain.Exam;
import domain.PageBean;
import domain.Student;
import service.StudentService;
import service.TeacherService;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentManagerServlet")
public class StudentManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");

        TeacherService teacherService = new TeacherServiceImpl();
        int examId = ((Exam)request.getSession().getAttribute("exam")).getId();
        PageBean<Student> pb = teacherService.findStudentByPage_and_ExamId(currentPage, rows, examId);
        request.getSession().setAttribute("pb", pb);
        request.getRequestDispatcher("/jsp/teacher/insertStudent.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
