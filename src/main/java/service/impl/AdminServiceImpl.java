package service.impl;

import dao.AdminDao;
import dao.ExamDao;
import dao.TeacherDao;
import dao.impl.AdminDaoImpl;
import dao.impl.ExamDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Admin;
import domain.Exam;
import domain.PageBean;
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
        teacherDao.findTeacherByUsername(teacher.getUsername());
        teacherDao.addTeacher(teacher);
        if (teacher.getIsAdmin() == 1) {
            adminDao.addAdmin(teacher.getUsername(), teacher.getPassword());
        }
    }

    @Override
    public void delTeacher(String id) {
        teacherDao.delTeacher(id);
    }

    @Override
    public void delSelectedTeachers(String[] tids) {
        for (String tid : tids) {
            teacherDao.delTeacher(tid);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
        if (teacher.getIsAdmin() == 1) {
            adminDao.addAdmin(teacher.getUsername(), teacher.getPassword());
        }
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherDao.findTeacherById(id);
    }

    @Override
    public List<Teacher> findTeachers() {
        return teacherDao.findTeachers();
    }

    @Override
    public PageBean<Teacher> findTeacherByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Teacher> pb = new PageBean<Teacher>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = teacherDao.findTotalCount();
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Teacher> teachers = teacherDao.findByPage(start, rows);
        pb.setList(teachers);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
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
