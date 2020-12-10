package web.servlet.teacher;

import domain.Student;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/unlockStudentByIpServlet")
public class UnlockStudentByIpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String sno = request.getParameter("sno");

        TeacherService teacherService = new TeacherServiceImpl();
        Student foundStudent = teacherService.unlockStudent(sno);

        HttpSession session = request.getSession();
        session.setAttribute("foundStudent", foundStudent);
        response.sendRedirect("jsp/teacher/unlockStudent.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
