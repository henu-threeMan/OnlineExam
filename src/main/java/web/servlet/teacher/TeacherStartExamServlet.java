package web.servlet.teacher;

import domain.Exam;
import domain.Student;
import org.apache.commons.beanutils.BeanUtils;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

@WebServlet("/teacherStartExamServlet")
public class TeacherStartExamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        TeacherService teacherService = new TeacherServiceImpl();
        Exam exam = teacherService.findExamById(id);

        if (exam.getStartTime().getTime() - (new Date()).getTime() >= 15 * 60 * 1000) {
            response.sendRedirect(request.getContextPath() + "/teacherBeforeExamManagerServlet?username=" + username + "&currentPage=1&rows=5");
        } else {
            teacherService.startExam(id);
            response.sendRedirect(request.getContextPath() + "/teacherGetExamServlet?username=" + username + "&id=" + id);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
