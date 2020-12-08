package service;

import domain.Exam;
import domain.PageBean;
import domain.Teacher;

public interface TeacherService {
    // 教师登录
    Teacher teacherLogin(Teacher teacher);

    // 考试管理

        // 考试表分页查询
    PageBean<Exam> findTeacherByPage(String _currentPage, String _rows);
        // 新建考试
    void addExam(Exam exam);
        // 编辑考试
    void updateExam(Exam exam);
        // 结束考试

        // 查看考试情况

        // 考试清理和删除
    void delExam(String id);

    void delSelectedTeachers(String[] eids);

    // 学生信息管理
        // 增、删、改、查

        // 解除学生登录锁定

    // 通知管理 发通知

    // 答卷下载

    // 导出提交信息
}
