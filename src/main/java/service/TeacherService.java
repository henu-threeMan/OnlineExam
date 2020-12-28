package service;

import domain.*;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    // 教师登录
    Teacher teacherLogin(Teacher teacher);

    //教师修改密码
    void updateTeacher(Teacher teacher);
    // 获取教师信息
    Teacher findTeacherByUsername(String username);

    // 考试管理

    // 获取考试信息
    Exam findExamById(String id);
    // 新建考试
    void addExam(Exam exam);
    // 编辑考试
    void updateExam(Exam exam);
    // 开启考试
    void startExam(String id);
    // 结束考试
    void stopExam(String id);
    // 考试表分页查询
    PageBean<Exam> findExamByPage(String _currentPage, String _rows, String owner);
    // 清理考试
    void cleanExam(String id);
    // 删除考试
    void delExam(String id);

    // 学生信息管理
        // 增、删、改、查
    void addStudent(Student student);

    void delStudent(String sno);

    int getStudentNum(int exmaId);

    Student findStudentByCondition(Map<String, String[]> condition);

    Student findStudentByIp(String ip);

    PageBean<Student> findStudentByPage_and_ExamId(String _currentPage, String _rows , int examId);

    int findTotalStudentsByExam(String examId);

    int findLoginStudentsByExam(String examId);

    int findCommitStudentsByExam(String examId);
    // 解除学生登录锁定
    Student unlockStudent(String sno);

    void updateStudentIp(Student stu);

    // 答卷下载

    // 导出提交信息
}
