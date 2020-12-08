package dao.impl;

import dao.ExamDao;
import domain.Exam;
import domain.Teacher;
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
        String sql = "update exam set examName=?, startTime=?, owner=?, isPageExist=?, isAutoStart=?, " +
                "isStarting=?, isFinished=?, isFiled=?, isCleaned=? where id = ?";
        jdbcTemplate.update(sql, null, exam.getExamName(), exam.getStartTime(), exam.getOwner(), exam.getExamName(),
                exam.getStartTime(), exam.getOwner(), exam.getIsPageExist(), exam.getIsAutoStart(), exam.getIsStarting(),
                exam.getIsFinished(), exam.getIsFiled(), exam.getIsCleaned(), exam.getId());
    }

    @Override
    public List<Exam> findByPage(int start, int rows) {
        String sql = "select * from exam limit ?, ?";
        try {
            List<Exam> exams = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Exam>(Exam.class), start, rows);
            return exams;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from exam";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }
}
