package dao.impl;

import dao.ExamDao;
import domain.Exam;
import domain.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

public class ExamDaoImpl implements ExamDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addExam(Exam exam) {
        String sql = "insert into exam values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, exam.getExamName(), exam.getStartTime(), exam.getOwner(), exam.getIsPageExist(),
                exam.getIsAutoStart(), exam.getIsStarting(), exam.getIsFinished(), exam.getIsFiled(), exam.getIsCleaned());
    }

    @Override
    public void delExam(int id) {
        String sql = "delete from exam where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateExam(Exam exam) {
        String sql = "update exam set examName=?, startTime=? where id = ?";
        jdbcTemplate.update(sql, exam.getExamName(), exam.getStartTime(), exam.getId());
    }

    @Override
    public List<Exam> findAll() {
        String sql = "select * from exam";
        try {
            List<Exam> exams = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class));
            return exams;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Exam> findByPage(int start, int rows, String owner) {
        String sql = null;
        List<Exam> exams = new ArrayList<Exam>();
        try {
            if (owner == null) {
                sql = "select * from exam limit ?, ?";
                exams = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class), start, rows);
            } else {
                sql = "select * from exam where owner = ? limit ?, ?";
                exams = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class), owner, start, rows);
            }
            return exams;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Exam findById(int id) {
        String sql = "select * from exam where id = ?";
        try {
            Exam exam = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Exam>(Exam.class), id);
            return exam;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int findTotalCount(String owner) {
        String sql = null;
        int count = 0;
        if (owner == null) {
            sql = "select count(*) from exam";
            count = jdbcTemplate.queryForObject(sql, Integer.class);
        } else {
            sql = "select count(*) from exam where owner = ?";
            count = jdbcTemplate.queryForObject(sql, Integer.class, owner);
        }
        return count;
    }

    @Override
    public void setExamStarting(int id) {
        String sql = "update exam set isStarting = 1 where id = ?";
        String sql1 = "update students set isExamStarting = 1 where examid=?";
        jdbcTemplate.update(sql, id);
        jdbcTemplate.update(sql1, id);
    }

    @Override
    public void setExamFinished(int id) {
        String sql = "update exam set isStarting = 0, isFinished = 1 where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void cleanExam(int id) {
        String sql = "update exam set isCleaned = 1 where id = ?";
        String sql1 = "delete from students where examid = ?";
        jdbcTemplate.update(sql, id);
        jdbcTemplate.update(sql1, id);
    }
}
