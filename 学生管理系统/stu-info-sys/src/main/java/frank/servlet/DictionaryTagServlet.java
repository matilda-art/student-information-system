package frank.servlet;

import frank.dao.DictionaryTagDAO;
import frank.model.DictionaryTag;
import frank.model.Response;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-07-31 19:36
 **/

//Servlet路径一定要以/开头，否则启动Tomcat就会报错
//熟悉开发流程，至少可以根据接口文档，数据库的定义等等。知道从哪复制
@WebServlet("/dict/tag/query")
public class DictionaryTagServlet extends AbstractBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDAO.query(key);
    }

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDAO.query(key);
        return tags;
    }
}
