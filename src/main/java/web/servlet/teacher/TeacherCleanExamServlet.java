package web.servlet.teacher;

import service.TeacherService;
import service.impl.TeacherServiceImpl;
import util.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/teacherCleanExamServlet")
public class TeacherCleanExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("teacherCleanExamServlet------examId----"+id);
        TeacherService teacherService = new TeacherServiceImpl();
        teacherService.cleanExam(id);
        String examPath = request.getRealPath("/incoming/exam/exam"+id);
        String zipPath = request.getRealPath("/incoming/zip/exam"+id);
        File examFile = new File(examPath);
        File zipFile = new File(zipPath);
        if(examFile.exists()){
            System.out.println("examFile-----"+examFile.getName());
            FileUtils.deleteDir(examFile);
        }
        if(zipFile.exists()){
            System.out.println("zipFile-----"+zipFile.getName());
            FileUtils.deleteDir(zipFile);
        }
        response.sendRedirect(request.getContextPath() + "/teacherAfterExamManagerServlet?currentPage=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
