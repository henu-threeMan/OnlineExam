package service.impl;

import dao.ExamDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.impl.ExamDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Exam;
import domain.PageBean;
import domain.Student;
import domain.Teacher;
import service.TeacherService;

import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    StudentDao studentDao = new StudentDaoImpl();
    ExamDao examDao = new ExamDaoImpl();

    @Override
    public Teacher teacherLogin(Teacher teacher) {
        return teacherDao.findTeacher(teacher.getUsername(), teacher.getPassword());
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        return teacherDao.findTeacherByUsername(username);
    }

    @Override
    public PageBean<Exam> findExamByPage(String _currentPage, String _rows, String owner) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Exam> pb = new PageBean<Exam>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = examDao.findTotalCount(owner);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Exam> exams = examDao.findByPage(start, rows, owner);
        pb.setList(exams);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Exam findExamById(String id) {
        return examDao.findById(Integer.parseInt(id));
    }

    @Override
    public void addExam(Exam exam) {
        examDao.addExam(exam);
    }

    @Override
    public void updateExam(Exam exam) {
        examDao.updateExam(exam);
    }

    @Override
    public void startExam(String id) {
        examDao.setExamStarting(id);
    }

    @Override
    public void stopExam(String id) {
        examDao.setExamFinished(Integer.parseInt(id));
    }

    @Override
    public void delExam(String id) {
        examDao.delExam(Integer.parseInt(id));
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void delStudent(String sno) {
        studentDao.delStudent(sno);
    }

    @Override
    public Student findStudentByCondition(Map<String, String[]> condition) {
        return studentDao.findStudentByCondition(condition);
    }

    @Override
    public Student findStudentByIp(String ip) {
        return studentDao.findStudentByIp(ip);
    }

    @Override
    public PageBean<Student> findStudentByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Student> pb = new PageBean<Student>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = studentDao.findTotalCount();
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Student> students = studentDao.findByPage(start, rows);
        pb.setList(students);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Student unlockStudent(String sno) {
        Student student = studentDao.findStudentBySno(sno);
        student.setIp(null);
        studentDao.updateStudent(student);
        return student;
    }
}
