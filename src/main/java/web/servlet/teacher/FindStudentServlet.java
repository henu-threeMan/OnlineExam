package web.servlet.teacher;

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
import javax.websocket.Session;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findStudentServlet")
public class FindStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        Map<String, String[]> maps = request.getParameterMap();
        TeacherService teacherService = new TeacherServiceImpl();
        Student foundStudent = teacherService.findStudentByCondition(maps);
        HttpSession session = request.getSession();
        session.setAttribute("foundStudent", foundStudent);

        String sourceUri = request.getHeader("referer");
        if (sourceUri.contains("unlockStudent.jsp")) {
            response.sendRedirect("jsp/teacher/unlockStudent.jsp");
        } else if (sourceUri.contains("studentManager.jsp")) {
            response.sendRedirect("jsp/teacher/studentManager.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
