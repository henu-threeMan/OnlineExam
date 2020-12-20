package web.listener;

import dao.ExamDao;
import dao.impl.ExamDaoImpl;
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
                String examId = null;
                // 若已有开启的考试则跳过
                if (servletContext.getAttribute("startingExam") == null) {
                    examId = listenerService.getStartingExam();
                    servletContext.setAttribute("startingExam", examId);
                }
            }

        }, 0, 100);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
