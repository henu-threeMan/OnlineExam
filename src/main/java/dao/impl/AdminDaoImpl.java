package dao.impl;

import dao.AdminDao;
import domain.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public void addAdmin(String username, String password) {
        String sql = "insert into admins values id = ?, username = ? and password = ?";
        jdbcTemplate.update(sql, null, username, password);
    }

    @Override
    public void delAdmin(String username) {
        String sql = "delete from admins where username = ?";
        jdbcTemplate.update(sql, username);
    }

    @Override
    public void updateAdmin(Admin admin) {
        String sql = "update admins set username = ?, password = ? where id = ?";
        jdbcTemplate.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
    }

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
    public List<Admin> findAdmins() {
        String sql = "select * from admins";
        try {
            List<Admin> admins = jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Admin>(Admin.class));
            return admins;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
