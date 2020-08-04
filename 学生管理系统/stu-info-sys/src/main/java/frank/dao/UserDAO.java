package frank.dao;

import frank.model.Classes;
import frank.model.Student;
import frank.model.User;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-04 17:07
 **/
public class UserDAO {

    public static User query(User u) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User query = null;

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            String sql  = "select id, nickname, email, create_time from user where username=? and password=?";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getPassword());
            //3、执行sql语句
            rs = ps.executeQuery();
            //4、处理查询结果集
            while (rs.next()){
                query = u;
                query.setId(rs.getInt("id"));
                query.setNickname(rs.getString("nickname"));
                query.setEmail(rs.getString("email"));
                query.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));

            }
            return query;
        }catch (Exception e){
            throw new RuntimeException("登录校验用户名密码出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }
}
