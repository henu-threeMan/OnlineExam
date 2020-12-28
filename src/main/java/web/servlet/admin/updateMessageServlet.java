package web.servlet.admin;

import domain.Admin;
import service.AdminService;
import service.impl.AdminServiceImpl;
import util.DigestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin_updateMessageServlet")
public class updateMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpass = request.getParameter("oldpass");
        String newpass1 = request.getParameter("newpass1");
        String newpass2 = request.getParameter("newpass2");
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String username = admin.getUsername();
        String password = admin.getPassword();
        Integer id = admin.getId();

        if(!password.equals(DigestUtil.md5(oldpass))) {
            session.setAttribute("update_msg", "原密码错误！");
            response.sendRedirect(request.getContextPath()+"/jsp/admin/home.jsp");
        }else if(!newpass1.equals(newpass2)){
            session.setAttribute("update_msg","密码不一致！");
            response.sendRedirect(request.getContextPath()+"/jsp/admin/home.jsp");
        }else{
            Admin newAdmin = new Admin();
            newAdmin.setUsername(username);
            newAdmin.setPassword(newpass2);
            newAdmin.setId(id);

            AdminService as = new AdminServiceImpl();
            as.updateAdmin(newAdmin);
            response.sendRedirect(request.getContextPath()+"/login.jsp");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
