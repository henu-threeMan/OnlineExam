package service;

import domain.Exam;

public interface ListenerService {
    Exam getStartingExam();

    void startExam(int examId);
}
