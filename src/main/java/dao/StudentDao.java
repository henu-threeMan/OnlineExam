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
}
