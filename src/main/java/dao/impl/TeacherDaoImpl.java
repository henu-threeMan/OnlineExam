package dao.impl;

import dao.TeacherDao;
import domain.Student;
import domain.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addTeacher(Teacher teacher) {
        String sql = "insert into teachers values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, teacher.getUsername(), teacher.getTeacherName(),
                teacher.getPassword(), teacher.getIsAdmin());
    }

    @Override
    public void delTeacher(String username) {
        String sql = "delete from teachers where username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "update teachers set teacherName = ?, password = ?, isAdmin = ? where username = ?";
        jdbcTemplate.update(sql, teacher.getTeacherName(), teacher.getPassword(), teacher.getIsAdmin(),
                teacher.getUsername());
    }

    @Override
    public Teacher findTeacher(String username, String password) {
        String sql = "select * from teachers where username = ? and password = ?";
        try {
            Teacher teacher = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Teacher>(Teacher.class), username, password);
            return teacher;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Teacher> findTeachers() {
        String sql = "select * from teachers";
        try {
            List<Teacher> teachers = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Teacher>(Teacher.class));
            return teachers;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
