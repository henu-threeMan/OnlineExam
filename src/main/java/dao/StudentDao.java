package dao;

import domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    void addStudent(Student student);

    void delStudent(String sno);

    void updateStudent(Student student);

    Student findStudent(String sno, String password);

    List<Student> findStudents();

    Student findStudentByCondition(Map<String, String[]> condition);

    Student findStudentByIp(String ip);

    Student findStudentBySno(String sno);

    int findTotalCount();

    int findTotalCountByExamId(int examId);

    List<Student> findByPage(int start, int rows);

    List<Student> findByPage_and_ExamId(int start, int rows , int examId);


    int findLoginCountByExamId(int id);

    int findCommitCountByExamId(int id);

    void updateIp(Student student);
}
