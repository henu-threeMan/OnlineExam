package dao;

import domain.Admin;

import java.util.List;

public interface AdminDao {
    void addAdmin(String username, String password);

    void delAdmin(String username);

    void updateAdmin(Admin admin);

    Admin findAdminByUsername(String username);

    Admin findAdmin(String username, String password);

    List<Admin> findAdmins();
}
