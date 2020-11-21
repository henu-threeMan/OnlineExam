package dao.impl;

import dao.ExamDao;
import domain.Exam;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class ExamDaoImpl implements ExamDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addExam(Exam exam) {
        String sql = "insert into exam values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, null, exam.getExamName(), exam.getStartTime(), exam.getOwner(), exam.isPageExist(),
                exam.isAutoStart(), exam.isStarting(), exam.isFinished(), exam.isFiled(), exam.isCleaned());
    }

    @Override
    public void delExam(int id) {
        String sql = "delete from exam where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Exam exam) {
        String sql = "update exam set examName=?, startTime=?, owner=?, isPageExist=?, isAutoStart=?, " +
                "isStarting=?, isFinished=?, isFiled=?, isCleaned=?";
        jdbcTemplate.update(sql, null, exam.getExamName(), exam.getStartTime(), exam.getOwner(), exam.isPageExist(),
                exam.isAutoStart(), exam.isStarting(), exam.isFinished(), exam.isFiled(), exam.isCleaned());
    }

    @Override
    public List<Exam> findExams() {
        String sql = "select * from exam";
        try {
            List<Exam> exams = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class));
            return exams;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
