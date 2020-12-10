package test;

import dao.ExamDao;
import dao.StudentDao;
import dao.impl.ExamDaoImpl;
import dao.impl.StudentDaoImpl;
import domain.Exam;
import domain.Student;
import domain.Teacher;
import org.junit.Test;
import service.StudentService;
import service.TeacherService;

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

//    @Test
    public void updateExam() {
        ExamDao examDao = new ExamDaoImpl();
        Exam exam = examDao.findById(2);
        System.out.println(exam);
        exam.setIsFinished(1);
        System.out.println(exam);
        examDao.setExamFinished(exam.getId());
        Exam newExam = examDao.findById(2);
        System.out.println(newExam);
    }
}
