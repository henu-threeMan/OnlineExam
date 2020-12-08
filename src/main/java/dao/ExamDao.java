package dao;

import domain.Exam;

import java.util.List;

public interface ExamDao {
    void addExam(Exam exam);

    void delExam(int id);

    void updateExam(Exam exam);

    List<Exam> findByPage(int start, int rows);

    int findTotalCount();
}
