package web.servlet.teacher;

import domain.Exam;
import domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/teacherAddExamServlet")
public class TeacherAddExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> maps = request.getParameterMap();
        Exam exam = new Exam();
        try {
            BeanUtils.populate(exam, maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String examStartTime = request.getParameter("examStartTime");
        System.out.println(examStartTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd'T'HH:mm");
        try {
            Date startTime = sdf.parse(examStartTime);
            exam.setStartTime(startTime);
        } catch (ParseException e) {
            response.sendRedirect(request.getContextPath() + "/teacherExamManagerServlet?currentPage=1&rows=5");
        }
        String username = request.getParameter("username");
        TeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = teacherService.findTeacherByUsername(username);
        exam.setOwner(teacher.getTeacherName());
        teacherService.addExam(exam);

        response.sendRedirect(request.getContextPath() + "/teacherBeforeExamManagerServlet?username=" + username + "&currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
