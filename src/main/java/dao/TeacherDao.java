package dao;

import domain.PageBean;
import domain.Teacher;

import java.util.List;

public interface TeacherDao {
    // 教师表 教师基本数据操作
    void addTeacher(Teacher teacher);

    void delTeacher(String id);

    void updateTeacher(Teacher teacher);

    Teacher findTeacher(String username, String password);

    List<Teacher> findTeachers();

    Teacher findTeacherById(String id);

    Teacher findTeacherByUsername(String username);

    int findTotalCount();

    List<Teacher> findByPage(int start, int rows);
}
