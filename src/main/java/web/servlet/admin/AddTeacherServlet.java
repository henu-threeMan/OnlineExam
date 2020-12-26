package web.servlet.admin;

import domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Teacher teacher = new Teacher();
        Map<String, String[]> maps = request.getParameterMap();

        try {
            BeanUtils.populate(teacher, maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if ("是".equals(request.getParameter("isAdmin"))) {
            teacher.setIsAdmin(1);
        } else {
            teacher.setIsAdmin(0);
        }

        AdminService adminService = new AdminServiceImpl();
        adminService.addTeacher(teacher);

        response.sendRedirect(request.getContextPath() + "/teacherManagerServlet?currentPage=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
