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
    public void addStudent(Student student) {
        String sql = "insert into students values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getSon(), student.getStudentName(), student.getPassword(),
                student.getClassName(), null);
    }

    @Override
    public void delStudent(String sno) {
        String sql = "delete from students where sno = ?";
        jdbcTemplate.update(sql, sno);
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "update students set studentName = ?, password = ?, className = ?, ip = ? where sno = ?";
        jdbcTemplate.update(sql, student.getStudentName(), student.getPassword(), student.getClassName(),
                student.getIp(), student.getSon());
    }

    @Override
    public Student findStudent(String sno, String password) {
        String sql = "select * from students where sno = ? and password = ?";
        try {
            Student student = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Student>(Student.class), sno, password);
            return student;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> findStudents() {
        String sql = "select * from students";
        try {
            List<Student> students = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Student>(Student.class));
            return students;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
