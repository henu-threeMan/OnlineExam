package web.servlet.teacher;

import domain.Exam;
import domain.Student;
import domain.Teacher;
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
import java.util.List;
import java.util.Map;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        Map<String, String[]> maps = request.getParameterMap();
        Student student = new Student();

        try {
            BeanUtils.populate(student, maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        student.setPassword(student.getStudentName());

        String sno = student.getSno().trim();
        String studentStudentName = student.getStudentName();
        student.setPassword(studentStudentName);
        TeacherService teacherService = new TeacherServiceImpl();
        String header = request.getHeader("referer");
        if (header.contains("studentManager.jsp")) {
            if (sno.equals("") || studentStudentName.equals("")) {
                response.sendRedirect("jsp/teacher/studentManager.jsp");
            } else {
                Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
                String startingExamId = (String) this.getServletContext().getAttribute(teacher.getUsername());
                student.setExamId(Integer.parseInt(startingExamId));
                teacherService.addStudent(student);
                response.sendRedirect("jsp/teacher/studentManager.jsp");
            }
        } else if (header.contains("studentManagerServlet")) {
            if (sno.equals("") || studentStudentName.equals("")) {
                response.sendRedirect(request.getContextPath() + "/studentManagerServlet?currentPage=1");
            } else {
                Exam exam = (Exam) request.getSession().getAttribute("exam");
                student.setExamId(exam.getId());
                teacherService.addStudent(student);
                response.sendRedirect(request.getContextPath() + "/studentManagerServlet?currentPage=1");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
