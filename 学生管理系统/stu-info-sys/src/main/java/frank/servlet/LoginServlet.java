package frank.servlet;

import frank.dao.UserDAO;
import frank.model.User;
import frank.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-04 16:49
 **/

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //前端请求的用户信息
        User u = JSONUtil.read(req.getInputStream(),User.class);
        //数据库校验用户名密码
        User query = UserDAO.query(u);
        if (query == null)
            throw new RuntimeException("用户名或密码校验失败");
        //通过用户名密码查询到用户时，生成session，并将用户保存到session中
        HttpSession session = req.getSession();//=getSession(true)，没有session时，创建一个
        session.setAttribute("user",query);
        return null;
    }
}
