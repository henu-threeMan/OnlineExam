package dao;

import domain.Admin;

public interface AdminDao {
    Admin findAdmin(String username, String password);

    int addAdmin(String username, String password);

    int delAdmin(String username);

    int updateAdmin(String username);

    int delDefaultAdmin();
}
