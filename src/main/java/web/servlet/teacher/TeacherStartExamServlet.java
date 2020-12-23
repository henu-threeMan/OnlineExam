package web.servlet.teacher;

import domain.Configuration;
import domain.Exam;
import domain.Student;
import domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletContext;
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
        ServletContext servletContext = this.getServletContext();
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String startingExamId = (String) servletContext.getAttribute(teacher.getUsername());
        System.out.println("startingExamId: " + startingExamId);
        if (startingExamId != null) {
            session.setAttribute("startExam_msg", "当前已有考试正在进行！");
            response.sendRedirect(request.getContextPath() + "/teacherGetExamServlet?id=" + id);
        } else {
            TeacherService teacherService = new TeacherServiceImpl();
            Exam exam = teacherService.findExamById(id);
            long time = exam.getStartTime().getTime() - (new Date()).getTime();
            Configuration config = (Configuration) servletContext.getAttribute("config");
            int interval = config.getInterval();
            if (exam.getIsFinished() == 0 && time < interval * 60 * 1000) {
                teacherService.startExam(id);
                this.getServletContext().setAttribute(teacher.getUsername(), id);
                response.sendRedirect(request.getContextPath() + "/teacherBeforeExamManagerServlet?currentPage=1");
            } else {
                session.setAttribute("startExam_msg", "考试前15分钟才能开启考试！");
                response.sendRedirect(request.getContextPath() + "/teacherGetExamServlet?id=" + id);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
