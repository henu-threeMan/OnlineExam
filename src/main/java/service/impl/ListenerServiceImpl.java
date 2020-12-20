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
    public String getStartingExam() {
        List<Exam> exams = examDao.findAll();
        long time = 0;
        for (Exam exam : exams) {
            time = exam.getStartTime().getTime() - (new Date()).getTime();
            if (exam.getIsFinished() == 0 && time <= 0) {
                examDao.setExamStarting(exam.getId());
                return Integer.toString(exam.getId());
            }
        }
        return null;
    }
}
