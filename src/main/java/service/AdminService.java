package service;

import domain.Admin;
import domain.Exam;
import domain.PageBean;
import domain.Teacher;

import java.util.List;

public interface AdminService {
    // 管理员登录
    Admin adminLogin(Admin admin);

    // 教师管理
    void addTeacher(Teacher teacher);

    void delTeacher(String username);

    void updateTeacher(Teacher teacher);

    Teacher findTeacherById(String id);

    List<Teacher> findTeachers();

    // 教师表 分页查询
    PageBean<Teacher> findTeacherByPage(String _currentPage, String _rows);

    // 考试清理
    List<Exam> findExams();

    void delExam(int id);

    // 系统配置

}
