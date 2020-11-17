package web.servlet;

import domain.Admin;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> adminMaps = request.getParameterMap();
        Admin loginAdmin = new Admin();

        try {
            BeanUtils.populate(loginAdmin, adminMaps);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.adminLogin(loginAdmin);
        if (admin != null) {
            request.setAttribute("admin_login_msg", "登录成功！" + admin.getUsername() + " 欢迎您！");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("admin_login_msg", "登录失败，用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
