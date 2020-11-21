package dao;

import domain.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void delStudent(String sno);

    void updateStudent(Student student);

    Student findStudent(String sno, String password);

    List<Student> findStudents();
}
