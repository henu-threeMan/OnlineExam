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
    public void delTeacher(String id) {
        String sql = "delete from teachers where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        String sql = "update teachers set username = ?, teacherName = ?, password = ?, isAdmin = ? where id = ?";
        jdbcTemplate.update(sql, teacher.getUsername(), teacher.getTeacherName(), teacher.getPassword(),
                teacher.getIsAdmin(), teacher.getId());
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

    @Override
    public Teacher findTeacherById(String id) {
        String sql = "select * from teachers where id = ?";
        try {
            Teacher teacher = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), id);
            return teacher;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Teacher findTeacherByUsername(String username) {
        String sql = "select * from teachers where username = ?";
        try {
            Teacher teacher = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), username);
            return teacher;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from teachers";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Teacher> findByPage(int start, int rows) {
        String sql = "select * from teachers limit ?, ?";
        try {
            List<Teacher> teachers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), start, rows);
            return teachers;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
