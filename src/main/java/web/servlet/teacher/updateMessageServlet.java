package web.servlet.teacher;

import domain.Admin;
import domain.Teacher;
import service.AdminService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/teacher_updateMessageServlet")
public class updateMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpass = request.getParameter("oldpass");
        String newpass1 = request.getParameter("newpass1");
        String newpass2 = request.getParameter("newpass2");
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)request.getSession().getAttribute("teacher");
        String username = teacher.getUsername();
        String password = teacher.getPassword();
        Integer id = teacher.getId();

        if(!password.equals(oldpass)) {
            session.setAttribute("update_msg", "原密码错误！");
            System.out.println("密码错误---------------");
            response.sendRedirect(request.getContextPath()+"/jsp/teacher/home.jsp");

        }else if(!newpass1.equals(newpass2)){
            session.setAttribute("update_msg","密码不一致！");
            System.out.println("密码不一致-------------");
            response.sendRedirect(request.getContextPath()+"/jsp/teacher/home.jsp");
        }else{
            Teacher newTeacher = new Teacher();
            newTeacher.setUsername(username);
            newTeacher.setTeacherName(teacher.getTeacherName());
            newTeacher.setPassword(newpass2);
            newTeacher.setIsAdmin(teacher.getIsAdmin());
            newTeacher.setId(id);

            TeacherService ts = new TeacherServiceImpl();
            ts.updateTeacher(newTeacher);
            response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
