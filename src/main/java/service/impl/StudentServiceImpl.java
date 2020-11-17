package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public Student studentLogin(Student student) {
        return studentDao.findStudent(student.getSon(), student.getPassword());
    }
}
