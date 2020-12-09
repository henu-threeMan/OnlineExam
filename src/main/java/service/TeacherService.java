package service;

import domain.Exam;
import domain.PageBean;
import domain.Student;
import domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    // 教师登录
    Teacher teacherLogin(Teacher teacher);

    Teacher findTeacherByUsername(String username);

    // 考试管理

        // 考试表分页查询
    PageBean<Exam> findTeacherByPage(String _currentPage, String _rows);

    Exam findExamById(String id);
        // 新建考试
    void addExam(Exam exam);
        // 编辑考试
    void updateExam(Exam exam);
        // 结束考试

        // 查看考试情况

        // 考试清理和删除
    void delExam(String id);

    // 学生信息管理
        // 增、删、改、查
    void addStudent(Student student);

    Student findStudentByCondition(Map<String, String[]> condition);
    // 解除学生登录锁定

    // 通知管理 发通知

    // 答卷下载

    // 导出提交信息
}
