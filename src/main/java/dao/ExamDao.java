package dao;

import domain.Exam;

import java.util.List;

public interface ExamDao {
    void addExam(Exam exam);

    void delExam(int id);

    void update(Exam exam);

    List<Exam> findExams();
}
