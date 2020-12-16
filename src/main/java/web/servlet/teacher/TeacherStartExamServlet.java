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
        TeacherService teacherService = new TeacherServiceImpl();
        Exam exam = teacherService.findExamById(id);

        long time = exam.getStartTime().getTime() - (new Date()).getTime();
        if (time > 0 && time < 15 * 60 * 1000) {
            teacherService.startExam(id);
            response.sendRedirect(request.getContextPath() + "/teacherBeforeExamManagerServlet?currentPage=1&rows=5");
        } else {
            session.setAttribute("startExam_msg", "考试前15分钟才能开启考试！");
            response.sendRedirect(request.getContextPath() + "/teacherGetExamServlet?id=" + id);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
