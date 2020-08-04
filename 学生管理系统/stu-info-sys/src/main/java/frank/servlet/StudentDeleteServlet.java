package frank.servlet;

import frank.dao.StudentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-04 16:03
 **/

@WebServlet("/student/delete")
public class StudentDeleteServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] ids = req.getParameterValues("ids");
        StudentDAO.delete(ids);
        return null;
    }
}
