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

@WebServlet("/updateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> maps = request.getParameterMap();
        Teacher teacher = new Teacher();

        try {
            BeanUtils.populate(teacher, maps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AdminService adminService = new AdminServiceImpl();
        adminService.updateTeacher(teacher);

        response.sendRedirect(request.getContextPath() + "/teacherManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
