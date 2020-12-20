package dao;

import domain.Exam;

import java.util.List;

public interface ExamDao {
    void addExam(Exam exam);

    void delExam(int id);

    void updateExam(Exam exam);

    List<Exam> findByPage(int start, int rows, String owner);

    Exam findById(int id);

    int findTotalCount(String owner);

    void setExamStarting(int id);

    void setExamFinished(int id);

    void setExamCleaned(int id);
}
