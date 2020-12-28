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
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> maps = request.getParameterMap();
        Teacher teacher = new Teacher();

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

        String username = teacher.getUsername().trim();
        String password = teacher.getPassword().trim();
        if (username.equals("") || password.equals("")) {
            response.sendRedirect("jsp/admin/addTeacher.jsp");
        } else {
            AdminService adminService = new AdminServiceImpl();
            adminService.updateTeacher(teacher);
            response.sendRedirect(request.getContextPath() + "/teacherManagerServlet?currentPage=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
