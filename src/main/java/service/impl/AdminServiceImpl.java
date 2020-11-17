package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import domain.Teacher;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin adminLogin(Admin admin) {
        return adminDao.findAdmin(admin.getUsername(), admin.getPassword());
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return 0;
    }

    @Override
    public int delTeacher(Teacher teacher) {
        return 0;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return 0;
    }

    @Override
    public Teacher findTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public boolean setTeacherAsAdmin(Teacher teacher) {
        return false;
    }
}
