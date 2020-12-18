package web.servlet.student;

import domain.Exam;
import domain.Student;
import domain.Teacher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet("/answerUploadServlet")
public class answerUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        Student student = (Student) request.getSession().getAttribute("student");
        Integer examId = student.getExamId();
        String sno = student.getSno();
        System.out.println("examId---------"+examId);

        PrintWriter out = response.getWriter();
        DiskFileItemFactory sf = new DiskFileItemFactory();//实例化磁盘被文件列表工厂
        String path = request.getRealPath("/incoming/student/"+"exam"+examId+"/"+sno);//得到上传文件的存放目录
        System.out.println(path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        sf.setRepository(file);//设置文件存放目录
        sf.setSizeThreshold(1024 * 1024);//设置文件上传小于1M放在内存中
        String rename = "";//文件新生成的文件名
        String fileName = "";//文件原名称
        String name = "";//普通field字段
        //从工厂得到servletupload文件上传类
        ServletFileUpload sfu = new ServletFileUpload(sf);

        try {
            List<FileItem> lst = sfu.parseRequest(request);//得到request中所有的元素
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField()) {
                    if ("name".equals(fileItem.getFieldName())) {
                        name = fileItem.getString("UTF-8");
                    }
                } else {
                    //获得文件名称
                    fileName = fileItem.getName();
                    if (fileName == null || fileName == "") {
                        request.getSession().setAttribute("AnswerUpload_msg", "请选择文件！");
                    }
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    String houzhui = fileName.substring(fileName.lastIndexOf("."));
                    request.getSession().setAttribute("AnswerUpload_filename", fileName);
                    fileItem.write(new File(path, fileName));
                    request.getSession().setAttribute("AnswerUpload_msg", "提交成功！");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/jsp/student/home.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
