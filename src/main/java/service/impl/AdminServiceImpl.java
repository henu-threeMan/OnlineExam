package service.impl;

import dao.AdminDao;
import dao.ExamDao;
import dao.TeacherDao;
import dao.impl.AdminDaoImpl;
import dao.impl.ExamDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Admin;
import domain.Exam;
import domain.Teacher;
import service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    TeacherDao teacherDao = new TeacherDaoImpl();
    ExamDao examDao = new ExamDaoImpl();

    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.findAdmin(admin.getUsername(), admin.getPassword());
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void delTeacher(String username) {
        teacherDao.delTeacher(username);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> findTeachers() {
        return teacherDao.findTeachers();
    }

    @Override
    public List<Exam> findExams() {
        return examDao.findExams();
    }

    @Override
    public void delExam(int id) {
        examDao.delExam(id);
    }
}
