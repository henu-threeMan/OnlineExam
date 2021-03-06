package web.servlet.teacher;

import domain.Exam;
import domain.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/examViewServlet")
public class ExamViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        ServletContext servletContext = this.getServletContext();
        String examId = (String) servletContext.getAttribute(teacher.getUsername());
        TeacherService teacherService = new TeacherServiceImpl();
        Exam exam = teacherService.findExamById(examId);
        int totalStudents = teacherService.findTotalStudentsByExam(examId);
        int loginStudents = teacherService.findLoginStudentsByExam(examId);
        int commitStudents = teacherService.findCommitStudentsByExam(examId);
        request.setAttribute("examName", exam.getExamName());
        request.setAttribute("totalStudents", totalStudents);
        request.setAttribute("loginStudents", loginStudents);
        request.setAttribute("commitStudents", commitStudents);
        request.getRequestDispatcher("jsp/teacher/examView.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
