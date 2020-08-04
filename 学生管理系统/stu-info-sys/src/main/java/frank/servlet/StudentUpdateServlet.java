package frank.servlet;

import frank.dao.StudentDAO;
import frank.model.Student;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-04 15:33
 **/

@WebServlet("/student/update")
public class StudentUpdateServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        StudentDAO.update(s);
        return null;
    }
}
