package dao;

import domain.Student;

import java.util.List;

public interface StudentDao {
    Student findStudent(String sno, String password);

    List<Student> getStudents();

    int addStudent(String sno, String name, String password);

    int delStudent(String sno);

    int updateStudent(String sno, String name, String password);
}
