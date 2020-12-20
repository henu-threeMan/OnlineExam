package web.filter;

import dao.ExamDao;
import dao.impl.ExamDaoImpl;
import domain.Exam;
import domain.Teacher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = {"/examViewServlet", "/jsp/teacher/studentManager.jsp", "/jsp/teacher/unlockStudent.jsp", "/jsp/teacher/notificationManager.jsp"})
public class ExamFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        ServletContext servletContext = req.getServletContext();
        String startingExamId = (String) servletContext.getAttribute("startingExam");
        if (startingExamId == null) {
            request.getRequestDispatcher("/jsp/teacher/noExam.jsp").forward(request, resp);
        } else {
            ExamDao examDao = new ExamDaoImpl();
            Exam exam = examDao.findById(Integer.parseInt(startingExamId));
            Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
            if (!teacher.getUsername().equals(exam.getOwner())){
                request.getRequestDispatcher("/jsp/teacher/noExam.jsp").forward(request, resp);
            } else {
                chain.doFilter(req, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
