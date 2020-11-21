package service;

import domain.Admin;
import domain.Exam;
import domain.Teacher;

import java.util.List;

public interface AdminService {
    // 管理员登录
    Admin adminLogin(Admin admin);

    // 教师管理
    void addTeacher(Teacher teacher);

    void delTeacher(String username);

    void updateTeacher(Teacher teacher);

    List<Teacher> findTeachers();

    // 考试清理
    List<Exam> findExams();

    void delExam(int id);

    // 系统配置

}
