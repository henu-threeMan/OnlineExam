package dao.impl;

import dao.AdminDao;
import domain.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public Admin findAdmin(String username, String password) {
        String sql = "select * from admins where username = ? and password = ?";
        try {
            Admin admin = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<Admin>(Admin.class), username, password);
            return admin;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public int addAdmin(String username, String password) {
        String sql = "insert into admins values username = ? and password = ?";
        int count = jdbcTemplate.update(sql, username, password);
        return count;
    }

    @Override
    public int delAdmin(String username) {
        String sql = "delete from admins where username = ?";
        int count = jdbcTemplate.update(sql, username);
        return count;
    }

    @Override
    public int updateAdmin(String username) {
        return 0;
    }

    @Override
    public int delDefaultAdmin() {
        return this.delAdmin("admin");
    }
}
