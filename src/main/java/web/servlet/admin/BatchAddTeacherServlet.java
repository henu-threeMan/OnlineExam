package web.servlet.admin;

import domain.Teacher;
import service.AdminService;
import service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Map;

import static util.ExcelUtils.readExcel;

@WebServlet("/BatchAddTeacherServlet")
public class BatchAddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminService as = new AdminServiceImpl();
        HttpSession session = request.getSession();
        try {
            String filename = (String) request.getSession().getAttribute("batch_filename");
            System.out.println(filename);
            String path = this.getServletContext().getRealPath("incoming/admin/"+filename);
            System.out.println(path);
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            List<Map<String, Object>> list = readExcel(file.getName(),is);
            if(list == null){
                session.setAttribute("batch_status","文件为空！");
            }
            else {
                for (Map<String, Object> lt : list) {
                    Teacher teacher = new Teacher();
                    teacher.setId(null);
                    teacher.setUsername((String) lt.get("用户名"));
                    teacher.setTeacherName((String) lt.get("真实名字"));
                    teacher.setPassword((String) lt.get("密码"));
                    teacher.setIsAdmin(((String) lt.get("是否为管理员")).equals("是") ? 1 : 0);
                    System.out.println(teacher);
                    as.addTeacher(teacher);
                }
                session.setAttribute("batch_status", "导入成功！");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/teacherManagerServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
