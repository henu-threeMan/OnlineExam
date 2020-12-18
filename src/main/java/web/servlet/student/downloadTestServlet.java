package web.servlet.student;

import domain.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/downloadTestServlet")
public class downloadTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int examId = ((Student)req.getSession().getAttribute("student")).getExamId();
        String path = this.getServletContext().getRealPath("incoming/teacher/testPaper/exam")+examId+"/";
        File dir = new File(path);
        File[] file = dir.listFiles();
        String filename = path+file[0].getName();
        //3.把资源加载进内存（文件输入流）
        FileInputStream fileInputStream = new FileInputStream(filename);
        //4.设置response响应头
        //4.1 content-Type
        String mimeType = this.getServletContext().getMimeType(filename);
        resp.setHeader("content-Type",mimeType);
        //4.2 content-disposition 同时要解决资源中文名编码问题
        filename = URLEncoder.encode(filename, "utf-8");
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //5.将文件输入流的数据存入buf缓冲数组，并输出
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buf = new byte[1024*8];
        int len = 0;
        while((len = fileInputStream.read(buf)) != -1){
            outputStream.write(buf,0,len);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
