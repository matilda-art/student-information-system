package frank.servlet;

import frank.dao.ClassesDAO;
import frank.model.Classes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-03 15:55
 **/

@WebServlet("/classes/queryAsDict")
public class ClassesQueryAsDictServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Classes> list = ClassesDAO.queryAsDict();
        return list;
    }
}
