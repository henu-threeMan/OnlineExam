package test;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
import org.junit.Test;
import service.StudentService;

import java.util.List;

public class TeacherFunctionTest {
    //@Test
    public void showStudentList() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.findStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
