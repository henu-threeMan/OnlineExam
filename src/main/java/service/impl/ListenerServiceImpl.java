package service.impl;

import dao.ExamDao;
import dao.impl.ExamDaoImpl;
import domain.Exam;
import service.ListenerService;

import java.util.Date;
import java.util.List;

public class ListenerServiceImpl implements ListenerService {
    ExamDao examDao = new ExamDaoImpl();

    @Override
    public int getPeriod() {
        return 2000;
    }

    @Override
    public Exam getStartingExam() {
        List<Exam> exams = examDao.findAll();
        long time = 0;
        for (Exam exam : exams) {
            time = exam.getStartTime().getTime() - (new Date()).getTime();
            if (exam.getIsFinished() == 0 && time <= 0) {
                return exam;
            }
        }
        return null;
    }

    @Override
    public void startExam(int examId) {
        examDao.setExamStarting(examId);
    }
}
