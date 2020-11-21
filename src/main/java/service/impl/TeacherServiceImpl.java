package service.impl;

import dao.AdminDao;
import dao.TeacherDao;
import dao.impl.AdminDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Teacher;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Teacher teacherLogin(Teacher teacher) {
        return teacherDao.findTeacher(teacher.getUsername(), teacher.getPassword());
    }
}
