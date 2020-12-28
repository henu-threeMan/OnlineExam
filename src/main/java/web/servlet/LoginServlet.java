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
import java.net.InetAddress;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Map<String, String[]> maps = request.getParameterMap();
        String role = request.getParameter("role");
        session.setAttribute("role", role);
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
                session.setAttribute("admin", adminLogin);
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
                response.sendRedirect(request.getContextPath() + "/jsp/teacher/home.jsp");
//                request.getRequestDispatcher("/jsp/admin/home.jsp").forward(request, response);
            } else {
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else if ("student".equals(role)) {
            Student student = new Student();
            System.out.println("sno:"+maps.get("sno")[0]);
            System.out.println("password:"+maps.get("password")[0]);
            student.setSno(maps.get("sno")[0]);
            student.setPassword(maps.get("password")[0]);
            StudentService studentService = new StudentServiceImpl();
            TeacherService teacherService = new TeacherServiceImpl();
            Student studentLogin = studentService.studentLogin(student);
            System.out.println("LoginServlet------"+studentLogin);

            //获取本机ip
            InetAddress inetAddress=InetAddress.getLocalHost();
            String ip=inetAddress.getHostAddress().toString();
            System.out.println(ip);

            if(studentLogin != null && studentLogin.getIsExamStarting() == 0){
                request.setAttribute("login_msg", "考试尚未开始，不允许登陆！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else if (studentLogin != null && (studentLogin.getIp() == null && teacherService.findStudentByIp(ip) == null || studentLogin.getIp().equals(ip))) {
                teacherService.updateStudentIp(studentLogin);
                session.setAttribute("student", studentLogin);
                response.sendRedirect(request.getContextPath() + "/jsp/student/home.jsp");
            }else if(studentLogin != null && studentLogin.getIp() == null && teacherService.findStudentByIp(ip) != null){
                request.setAttribute("login_msg", "请到规定的电脑进行考试！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else {
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
