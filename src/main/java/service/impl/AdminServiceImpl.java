package service.impl;

import dao.AdminDao;
import dao.ExamDao;
import dao.TeacherDao;
import dao.impl.*;
import domain.*;
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
        if(teacherDao.findTeacherByUsername(teacher.getUsername()) == null) {
            teacherDao.addTeacher(teacher);
            if (teacher.getIsAdmin() == 1) {
                adminDao.addAdmin(teacher.getUsername(), teacher.getPassword());
            }
        }
    }

    @Override
    public void delTeacher(String id) {
        Teacher teacher = teacherDao.findTeacherById(id);
        if (teacher.getIsAdmin() == 1) {
            adminDao.delAdmin(teacher.getUsername());
        }
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
            Admin admin = adminDao.findAdminByUsername(teacher.getUsername());
            if (admin == null) {
                adminDao.addAdmin(teacher.getUsername(), teacher.getPassword());
            } else {
                admin.setUsername(teacher.getUsername());
                admin.setPassword(teacher.getPassword());
                adminDao.updateAdmin(admin);
            }
        } else {
            adminDao.delAdmin(teacher.getUsername());
        }
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherDao.findTeacherById(id);
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        return teacherDao.findTeacherByUsername(username);
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
    public PageBean<Exam> findExamByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Exam> pb = new PageBean<Exam>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = examDao.findTotalCount(null);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Exam> exams = examDao.findByPage(start, rows, null);
        pb.setList(exams);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void cleanExam(String id) {
        examDao.setExamCleaned(Integer.parseInt(id));
    }

    @Override
    public void deleteExam(String id) {
        examDao.delExam(Integer.parseInt(id));
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

}
