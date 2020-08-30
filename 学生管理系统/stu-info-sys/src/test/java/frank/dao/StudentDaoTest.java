package frank.dao;

import frank.model.Student;
import org.junit.Test;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-30 10:08
 **/
public class StudentDaoTest {

    @Test
    public void query() {
        Student student = new Student();
        student.setId(1);
        student.setClassesId(1);
        student.setClasses(null);
        student.setCreateTime(null);
        student.setStudentEmail("123");
        student.setIdCard("111");
        student.setStudentName("nico");
        student.setStudentNo("20");
    }

    @Test
    public void queryById() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.queryById(1);
    }

    @Test
    public void insert() {
        Student student = new Student();
        student.setId(2);
        student.setStudentNo("13");
        student.setStudentName("楚鹤");
        student.setIdCard("15");
        student.setStudentEmail("1234");
        student.setCreateTime(null);
        student.setClasses(null);
        student.setClassesId(123);
    }

    @Test
    public void update() {
        Student student = new Student();
        student.setId(1);
        student.setClassesId(23);
        student.setClasses(null);
        student.setCreateTime(null);
        student.setStudentEmail("2345");
        student.setIdCard("34");
        student.setStudentName("李承鄞");
        student.setStudentNo("111");
    }

    @Test
    public void delete() {
        StudentDAO studentDAO = new StudentDAO();
        String[] ids = {"12"};
        studentDAO.delete(ids);
    }
}
