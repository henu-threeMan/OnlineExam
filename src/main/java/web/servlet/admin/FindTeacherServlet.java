package web.servlet.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Teacher;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findTeacherServlet")
public class FindTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");

        AdminService adminService = new AdminServiceImpl();
        Teacher teacher = adminService.findTeacherByUsername(username);

        Map<String, Object> map = new HashMap<String, Object>();

        if (teacher != null) {
            map.put("teacherExist", true);
            map.put("msg", "该用户名已存在！");
        } else {
            map.put("teacherExist", false);
            map.put("msg", "用户名可用");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
