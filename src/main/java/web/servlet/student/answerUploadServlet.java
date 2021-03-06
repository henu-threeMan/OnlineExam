package web.servlet.student;

import domain.Exam;
import domain.Student;
import domain.Teacher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/answerUploadServlet")
public class answerUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        Student student = (Student) request.getSession().getAttribute("student");
        StudentService studentService = new StudentServiceImpl();
        studentService.setStudentCommit(student.getSno());
        Integer examId = student.getExamId();
        String sno = student.getSno();
        System.out.println("examId---------"+examId);

        PrintWriter out = response.getWriter();
        DiskFileItemFactory sf = new DiskFileItemFactory();//实例化磁盘被文件列表工厂
        String path = request.getRealPath("/incoming/exam/exam"+examId+"/studentAnswer/"+sno);//得到上传文件的存放目录
        request.setAttribute("dirPath",path);
        File file  = new File(path);
        if(!file.exists()){
            file.mkdirs();
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
                    request.getSession().setAttribute("AnswerUpload_filename", fileName);

                    //设置上传时间
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(System.currentTimeMillis());
                    File newFile = new File(path, fileName);
                    newFile.setLastModified(date.getTime());
                    fileItem.write(newFile);
                    request.getSession().setAttribute("AnswerUpload_msg", "提交成功！");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getRequestDispatcher("/answerListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
