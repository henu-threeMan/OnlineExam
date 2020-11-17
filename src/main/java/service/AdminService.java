package service;

import domain.Admin;
import domain.Teacher;

public interface AdminService {
    // 管理员登录
    Admin adminLogin(Admin admin);

    // 教师管理
    int addTeacher(Teacher teacher);

    int delTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    Teacher findTeacher(Teacher teacher);

    boolean setTeacherAsAdmin(Teacher teacher);

    // 考试清理

    // 系统配置

}
