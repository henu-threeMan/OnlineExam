package dao;

import domain.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Teacher teacher);

    void delTeacher(String username);

    void updateTeacher(Teacher teacher);

    Teacher findTeacher(String username, String password);

    List<Teacher> findTeachers();
}
