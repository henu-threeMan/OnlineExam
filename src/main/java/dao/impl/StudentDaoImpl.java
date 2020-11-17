package dao.impl;

import dao.StudentDao;
import domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Student findStudent(String sno, String password) {
        String sql = "select * from student where sno = ? and password = ?";
        try {
            Student student = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Student>(Student.class), sno, password);
            return student;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> getStudents() {
        String sql = "select * from student";
        try {
            List<Student> students = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Student>(Student.class));
            return students;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int addStudent(String sno, String name, String password) {
        String sql = "insert into student values(?, ?, ?)";
        int count = jdbcTemplate.update(sql, sno, name, password);
        return count;
    }

    @Override
    public int delStudent(String sno) {
        String sql = "delete from student where sno = ?";
        int count = jdbcTemplate.update(sql, sno);
        return count;
    }

    @Override
    public int updateStudent(String sno, String name, String password) {
        return 0;
    }
}
