package web.servlet.teacher;

import domain.Student;
import org.apache.poi.ss.usermodel.Cell;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

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

@WebServlet("/BatchAddStudentServlet")
public class BatchAddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService ts = new TeacherServiceImpl();
        HttpSession session = request.getSession();
        try {
            String filename = (String) request.getSession().getAttribute("StudentListUpload_filename");
            String path = this.getServletContext().getRealPath("incoming/teacher/studentList/"+filename);
            File file = new File(path);
            InputStream is = new FileInputStream(file);
            List<Map<String, Object>> list = readExcel(file.getName(),is);
            if(list == null){
                session.setAttribute("batch_status","文件为空！");
            }
            else {
                for (Map<String, Object> lt : list) {
                    Student student = new Student();
                    student.setSno((String)lt.get("sno"));
                    student.setStudentName( (String)lt.get("studentName"));
                    student.setPassword((String)lt.get("password"));
                    student.setClassName((String)lt.get("className"));
                    student.setIp((String)lt.get("ip"));
                    student.setExamId(Integer.parseInt((String)lt.get("examId")));
                    student.setIsExamStarting(Integer.parseInt((String)lt.get("isExamStarting")));
                    student.setIsLogin(Integer.parseInt((String)lt.get("isLogin")));
                    student.setIsCommit(Integer.parseInt((String)lt.get("isCommit")));
                    ts.addStudent(student);
                }
                session.setAttribute("batch_status", "导入成功！");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/studentManagerServlet?exam=2&currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
