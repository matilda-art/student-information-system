package frank.servlet;

import frank.dao.StudentDAO;
import frank.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-04 10:18
 **/

@WebServlet("/student/queryById")
public class StudentQueryByIdServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Student s = StudentDAO.queryById(Integer.parseInt(id));
        return s;
    }
}
