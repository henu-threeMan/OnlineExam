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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date startTime = sdf.parse(examStartTime);
            exam.setStartTime(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        exam.setOwner(teacher.getTeacherName());
        teacherService.addExam(exam);

        response.sendRedirect(request.getContextPath() + "/teacherBeforeExamManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
