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
    public Teacher findTeacher(String jobId, String password) {
        String sql = "select * from teacher where sno = ? and password = ?";
        try {
            Teacher teacher = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Teacher>(Teacher.class), jobId, password);
            return teacher;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Teacher> getTeachers() {
        String sql = "select * from teacher";
        try {
            List<Teacher> teachers = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Teacher>(Teacher.class));
            return teachers;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int addTeacher(String jobId, String name, String password) {
        String sql = "insert into teacher values(?, ?, ?, ?)";
        int count = jdbcTemplate.update(sql, jobId, name, password);
        return count;
    }

    @Override
    public int delTeacher(String jobId) {
        String sql = "delete from teacher where jobId = ?";
        int count = jdbcTemplate.update(sql, jobId);
        return count;
    }

    @Override
    public int updateTeacher(String jobId, String name, String password) {
        return 0;
    }
}
