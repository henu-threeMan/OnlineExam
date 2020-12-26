package web.servlet.teacher;

import domain.Exam;
import domain.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/teacherGetExamServlet")
public class TeacherGetExamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("startExam_msg");
        String id = request.getParameter("id");
        TeacherService teacherService = new TeacherServiceImpl();
        Exam exam = teacherService.findExamById(id);

        int studentNum = teacherService.getStudentNum(exam.getId());
        request.getSession().setAttribute("studentNum",studentNum);
        request.setAttribute("startExam_msg", msg);
        request.getSession().setAttribute("exam", exam);

        //在编辑考试前创建名为exam+examId的文件夹
        String path = this.getServletContext().getRealPath("incoming/teacher/testPaper/"+"exam"+((Exam)request.getSession().getAttribute("exam")).getId());
        File file = new File(path);
        if(file != null){
            file.mkdirs();
        }
        request.getRequestDispatcher("jsp/teacher/updateExam.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
