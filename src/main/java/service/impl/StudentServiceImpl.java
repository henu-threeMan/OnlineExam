package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public Student studentLogin(Student student) {
        return studentDao.findStudent(student.getSno(), student.getPassword());
    }

    @Override
    public void setStudentLogin(String sno) {
        studentDao.setLogin(sno);
    }

    @Override
    public void setStudentCommit(String sno) {
        studentDao.setCommit(sno);
    }

}
