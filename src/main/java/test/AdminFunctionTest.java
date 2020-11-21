package test;

import domain.Admin;
import domain.Teacher;
import org.junit.Test;
import service.AdminService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.TeacherServiceImpl;

import java.util.List;

public class AdminFunctionTest {

    @Test
    public void adminLogin() {
        AdminService adminService = new AdminServiceImpl();

        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");

        Admin loginAdmin = adminService.adminLogin(admin);
        assert (admin != null);
    }

    @Test
    public void addTeacher() {
        AdminService adminService = new AdminServiceImpl();

        Teacher teacher = new Teacher();
        teacher.setUsername("zhangsan");
        teacher.setTeacherName("张三");
        teacher.setPassword("123456");
        teacher.setAdmin(false);

        adminService.addTeacher(teacher);

        List<Teacher> teachers = adminService.findTeachers();
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    @Test
    public void updateTeacher() {
        AdminService adminService = new AdminServiceImpl();

        List<Teacher> teachers = adminService.findTeachers();
        for (Teacher t : teachers) {
            System.out.println(t);
        }

        Teacher teacher = new Teacher();
        teacher.setUsername("zhangsan");
        teacher.setTeacherName("张三");
        teacher.setPassword("12798147");
        teacher.setAdmin(true);

        adminService.updateTeacher(teacher);

        teachers = adminService.findTeachers();
        for (Teacher t : teachers) {
            System.out.println(t);
        }
    }

    @Test
    public void delTeacher() {
        AdminService adminService = new AdminServiceImpl();
        adminService.delTeacher("zhangsan");
        List<Teacher> teachers = adminService.findTeachers();
        assert (teachers.size() == 0);
    }
}
