package dao.impl;

import dao.StudentDao;
import domain.Exam;
import domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addStudent(Student student) {
        String sql = "insert into students values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getSno(), student.getStudentName(), student.getPassword(),
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
                student.getIp(), student.getSno());
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

    @Override
    public Student findStudentByCondition(Map<String, String[]> condition) {
        String sql = "select * from students where 1 = 1";
        StringBuilder stringBuilder = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        for (String key : condition.keySet()) {
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                stringBuilder.append(" and " + key + "= ?");
                params.add(value);
            }
        }
        try {
            Student aStudent = jdbcTemplate.queryForObject(stringBuilder.toString(),
                    new BeanPropertyRowMapper<Student>(Student.class), params.toArray());
            return aStudent;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Student findStudentByIp(String ip) {
        String sql = "select * from students where ip = ?";
        try {
            Student aStudent = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), ip);
            return aStudent;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Student findStudentBySno(String sno) {
        String sql = "select * from students where sno = ?";
        try {
            Student aStudent = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), sno);
            return aStudent;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from students";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Student> findByPage(int start, int rows) {
        String sql = "select * from students limit ?, ?";
        try {
            List<Student> students = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class), start, rows);
            return students;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
