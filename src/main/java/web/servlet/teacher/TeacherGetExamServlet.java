package web.servlet.teacher;

import domain.Exam;
import domain.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacherGetExamServlet")
public class TeacherGetExamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("startExam_msg");
        String username = request.getParameter("username");
        String id = request.getParameter("id");
        TeacherService teacherService = new TeacherServiceImpl();
        Exam exam = teacherService.findExamById(id);

        request.setAttribute("startExam_msg", msg);
        request.setAttribute("username", username);
        request.setAttribute("exam", exam);
        request.getRequestDispatcher("jsp/teacher/updateExam.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
