package frank.servlet;

import frank.dao.StudentDAO;
import frank.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-02 10:17
 **/

@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Student> students = StudentDAO.query();
        return students;
    }
}
