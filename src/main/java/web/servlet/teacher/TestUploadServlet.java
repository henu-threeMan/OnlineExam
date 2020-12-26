package web.servlet.teacher;

import domain.Exam;
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

@WebServlet("/TestUploadServlet")
public class TestUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        Exam exam = (Exam) request.getSession().getAttribute("exam");
        Integer examId = exam.getId();
        PrintWriter out = response.getWriter();
        DiskFileItemFactory sf = new DiskFileItemFactory();//实例化磁盘被文件列表工厂
        String path = request.getRealPath("/incoming/exam/exam"+examId+"/testPaper");//得到上传文件的存放目录
        File file  = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        sf.setRepository(new File(path));//设置文件存放目录
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
                        request.getSession().setAttribute("TestUpload_msg", "请选择文件！");
                    }
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    request.getSession().setAttribute("TestUpload_filename", fileName);
                    fileItem.write(new File(path, fileName));
                    request.getSession().setAttribute("TestUpload_msg", "上传成功！");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String teacherUsername = teacher.getUsername();
        response.sendRedirect(request.getContextPath()+"/teacherGetExamServlet?username="+teacherUsername+"&id="+examId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
