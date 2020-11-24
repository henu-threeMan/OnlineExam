package web.servlet;

import domain.Admin;
import domain.Student;
import domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminService;
import service.StudentService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Map<String, String[]> maps = request.getParameterMap();
        String role = request.getParameter("role");
        if ("admin".equals(role)) {
            Admin admin = new Admin();
            try {
                BeanUtils.populate(admin, maps);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            AdminService adminService = new AdminServiceImpl();
            Admin adminLogin = adminService.adminLogin(admin);
            if (adminLogin != null) {
                session.setAttribute("admin", adminLogin);;
                response.sendRedirect(request.getContextPath() + "/jsp/admin/home.jsp");
//                request.getRequestDispatcher("/jsp/admin/home.jsp").forward(request, response);
            } else {
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("teacher".equals(role)) {
            Teacher teacher = new Teacher();
            try {
                BeanUtils.populate(teacher, maps);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            TeacherService teacherService = new TeacherServiceImpl();
            Teacher teacherLogin = teacherService.teacherLogin(teacher);
            if (teacherLogin != null) {
                session.setAttribute("teacher", teacherLogin);;
                response.sendRedirect(request.getContextPath() + "/jsp/admin/home.jsp");
//                request.getRequestDispatcher("/jsp/admin/home.jsp").forward(request, response);
            } else {
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("student".equals(role)) {
            Student student = new Student();
            try {
                BeanUtils.populate(student, maps);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            StudentService studentService = new StudentServiceImpl();
            Student studentLogin = studentService.studentLogin(student);
            if (studentLogin != null) {
                session.setAttribute("student", studentLogin);;
                response.sendRedirect(request.getContextPath() + "/jsp/admin/home.jsp");
//                request.getRequestDispatcher("/jsp/admin/home.jsp").forward(request, response);
            } else {
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
