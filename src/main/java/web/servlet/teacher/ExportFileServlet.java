package web.servlet.teacher;

import domain.Exam;
import util.ZipUtils;

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

@WebServlet("/ExportFileServlet")
public class ExportFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("ExportFileServlet----examId---"+id);
        String srcPath = request.getRealPath("/incoming/exam/exam"+id);
        String desPath = request.getRealPath("/incoming/zip/exam"+id+"/");;

        File desDir = new File(desPath);
        if(!desDir.exists()){
            desDir.mkdirs();
        }
        //清空目标目录
        File[] fileList = desDir.listFiles();
        for (File file : fileList) {
            file.delete();
        }
        //压缩至目标目录
        ZipUtils.doZip(srcPath,desPath+"/exam"+id+".zip");

        //下载zip
        fileList = desDir.listFiles();
        String filename = desPath+fileList[0].getName();
        System.out.println(filename);

        //3.把资源加载进内存（文件输入流）
        FileInputStream fileInputStream = new FileInputStream(filename);
        //4.设置response响应头
        //4.1 content-Type
        String mimeType = this.getServletContext().getMimeType(filename);
        response.setHeader("content-Type",mimeType);
        //4.2 content-disposition 同时要解决资源中文名编码问题
        filename = URLEncoder.encode(filename, "utf-8");
        response.setHeader("content-disposition","attachment;filename="+filename);

        //5.将文件输入流的数据存入buf缓冲数组，并输出
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buf = new byte[1024*8];
        int len = 0;
        while((len = fileInputStream.read(buf)) != -1){
            outputStream.write(buf,0,len);
        }

        response.sendRedirect(request.getContextPath() + "/teacherAfterExamManagerServlet?currentPage=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
