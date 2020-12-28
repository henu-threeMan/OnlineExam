package service;

import domain.Student;

public interface StudentService {
    // 学生操作
    Student studentLogin(Student student);

    void setStudentLogin(String sno);

    void setStudentCommit(String sno);
}
