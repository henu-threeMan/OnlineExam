package service.impl;

import dao.AdminDao;
import dao.ExamDao;
import dao.TeacherDao;
import dao.impl.AdminDaoImpl;
import dao.impl.ExamDaoImpl;
import dao.impl.TeacherDaoImpl;
import domain.Exam;
import domain.PageBean;
import domain.Teacher;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    TeacherDao teacherDao = new TeacherDaoImpl();
    ExamDao examDao = new ExamDaoImpl();

    @Override
    public Teacher teacherLogin(Teacher teacher) {
        return teacherDao.findTeacher(teacher.getUsername(), teacher.getPassword());
    }

    @Override
    public PageBean<Exam> findTeacherByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<Exam> pb = new PageBean<Exam>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = examDao.findTotalCount();
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * rows;
        List<Exam> exams = examDao.findByPage(start, rows);
        pb.setList(exams);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void addExam(Exam exam) {
        examDao.addExam(exam);
    }

    @Override
    public void updateExam(Exam exam) {
        examDao.updateExam(exam);
    }

    @Override
    public void delExam(String id) {
        examDao.delExam(Integer.parseInt(id));
    }

    @Override
    public void delSelectedTeachers(String[] eids) {
        for (String eid : eids) {
            examDao.delExam(Integer.parseInt(eid));
        }
    }
}
