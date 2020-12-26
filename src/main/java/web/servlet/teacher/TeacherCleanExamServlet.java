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
        TeacherService teacherService = new TeacherServiceImpl();
        teacherService.cleanExam(id);
        String studentListPath = request.getRealPath("/incoming/teacher/studentList/"+"exam"+id);
        String testPaperPath = request.getRealPath("/incoming/teacher/testPaper/"+"exam"+id);
        String studentAnswerPath = request.getRealPath("/incoming/student/"+"exam"+id);
        File studentListFile = new File(studentListPath);
        File teacherPaperFile = new File(testPaperPath);
        File studentAnswerFile = new File(studentAnswerPath);
        if(studentListFile.exists()){
            System.out.println("studentListFile-----"+studentListFile.getName());
            FileUtils.deleteDir(studentListFile);
        }

        if(teacherPaperFile.exists()){
            System.out.println("teacherPaperFile-----"+teacherPaperFile.getName());
            FileUtils.deleteDir(teacherPaperFile);
        }

        if(studentAnswerFile.exists()){
            System.out.println("studentAnswerFile-----"+studentAnswerFile.getName());
            FileUtils.deleteDir(studentAnswerFile);
        }
        response.sendRedirect(request.getContextPath() + "/teacherAfterExamManagerServlet?currentPage=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
