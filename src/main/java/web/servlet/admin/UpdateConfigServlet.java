package web.servlet.admin;

import domain.Configuration;
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

@WebServlet("/updateConfigServlet")
public class UpdateConfigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Configuration configuration = new Configuration();
        try {
            BeanUtils.populate(configuration, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if ("on".equals(request.getParameter("teacherAuthority"))) {
            configuration.setTeacherAuthority(1);
        } else {
            configuration.setTeacherAuthority(0);
        }
        this.getServletContext().setAttribute("config", configuration);
        request.getRequestDispatcher("jsp/admin/config.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
