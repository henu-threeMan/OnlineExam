package dao;

import domain.Teacher;

import java.util.List;

public interface TeacherDao {
    Teacher findTeacher(String jobId, String password);

    List<Teacher> getTeachers();

    int addTeacher(String jobId, String name, String password);

    int delTeacher(String jobId);

    int updateTeacher(String jobId, String name, String password);
}
