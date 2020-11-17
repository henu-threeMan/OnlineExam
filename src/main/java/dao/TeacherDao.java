package dao;

import domain.Teacher;

import java.util.List;

public interface TeacherDao {
    void addTeacher(Teacher teacher);

    void delTeacher(String jobId);

    void updateTeacher(Teacher teacher);

    Teacher findTeacher(String jobId, String password);

    List<Teacher> getTeachers();
}
