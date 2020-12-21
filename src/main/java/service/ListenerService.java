package service;

import domain.Exam;

public interface ListenerService {
    int getPeriod();

    Exam getStartingExam();

    void startExam(int examId);
}
