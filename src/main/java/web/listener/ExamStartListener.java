package web.listener;

import dao.ExamDao;
import dao.impl.ExamDaoImpl;
import domain.Exam;
import service.ListenerService;
import service.impl.ListenerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@WebListener
public class ExamStartListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 创建定时器
        Timer timer = new Timer();
        // 给定时器添加任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 若考试时间已到 开启考试
                ListenerService listenerService = new ListenerServiceImpl();
                ServletContext servletContext = sce.getServletContext();
                Exam exam = listenerService.getStartingExam();
                // 若教师已有开启的考试则跳过
                if (exam != null && servletContext.getAttribute(exam.getOwner()) == null) {
                    servletContext.setAttribute(exam.getOwner(), Integer.toString(exam.getId()));
                    listenerService.startExam(exam.getId());
                }
            }

        }, 0, 100);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
