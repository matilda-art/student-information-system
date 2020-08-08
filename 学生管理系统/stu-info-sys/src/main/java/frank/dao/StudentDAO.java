package frank.dao;

import frank.model.Classes;
import frank.model.DictionaryTag;
import frank.model.Student;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-02 10:18
 **/
public class StudentDAO {
    public static List<Student> query() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            String sql  = "select s.id," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       s.create_time," +
                    "       c.id cid," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc," +
                    "       c.create_time" +
                    "   from student s" +
                    "         join classes c on s.classes_id = c.id";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            //3、执行sql语句
            rs = ps.executeQuery();
            //4、处理查询结果集
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard(rs.getString("id_card"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setClassesId(rs.getInt("classes_id"));
                //new Date()的类型的util的，但是从数据库中拿到的时间是sql的，所以需要使用.getTime()方法将其转换成long类型
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                Classes classes = new Classes();
                student.setClasses(classes);
                classes.setId(rs.getInt("cid"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                //设置属性：通过结果集获取来设置
                list.add(student);
            }
            return list;
        }catch (Exception e){
            throw new RuntimeException("查询学生列表出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }

    public static Student queryById(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student student = new Student();

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            String sql  = "select s.id," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       s.classes_id," +
                    "       s.create_time," +
                    "       c.id cid," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc," +
                    "       c.create_time" +
                    "   from student s" +
                    "         join classes c on s.classes_id = c.id" +
                    "   where s.id=?";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            //3、执行sql语句
            rs = ps.executeQuery();
            //4、处理查询结果集
            while (rs.next()){

                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentNo(rs.getString("student_no"));
                student.setIdCard(rs.getString("id_card"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setClassesId(rs.getInt("classes_id"));
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                Classes classes = new Classes();
                student.setClasses(classes);
                classes.setId(rs.getInt("cid"));
                classes.setClassesName(rs.getString("classes_name"));
                classes.setClassesGraduateYear(rs.getString("classes_graduate_year"));
                classes.setClassesMajor(rs.getString("classes_major"));
                classes.setClassesDesc(rs.getString("classes_desc"));
                //设置属性：通过结果集获取来设置

            }
            return student;
        }catch (Exception e){
            throw new RuntimeException("查询学生详情信息出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }

    public static void insert(Student s) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            String sql  = "insert into student(student_name,student_no, id_card, student_email, classes_id) values(?,?,?,?,?)";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentNo());
            ps.setString(3,s.getIdCard());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getClassesId());
            //3、执行sql语句
            int num = ps.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException("新增学生信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static void update(Student s) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            String sql  = "update student set student_name=?,student_no=?, id_card=?, student_email=?, classes_id=? where id=?";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentNo());
            ps.setString(3,s.getIdCard());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getClassesId());
            ps.setInt(6,s.getId());
            //3、执行sql语句
            int num = ps.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException("修改学生信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }

    public static void delete(String[] ids) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //关联班级表和学生表，查询需要的数据（学生的数据和班级的数据）
            StringBuilder sql  = new StringBuilder("delete from student where id in (");
            for(int i = 0;i < ids.length;i++){
                if (i != 0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");
            //2、创建操作命令对象
            ps = c.prepareStatement(sql.toString());
            for(int i = 0;i < ids.length;i++){
                //JDBC设置占位符是从1开始的
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }
            //3、执行sql语句
            int num = ps.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException("删除学生信息出错",e);
        }finally {
            DBUtil.close(c,ps);
        }
    }
}
