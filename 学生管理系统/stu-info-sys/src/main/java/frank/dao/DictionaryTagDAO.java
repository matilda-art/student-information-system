package frank.dao;

import frank.model.DictionaryTag;
import frank.util.DBUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-07-31 19:43
 **/
public class DictionaryTagDAO {
    public static List<DictionaryTag> query(String key) {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DictionaryTag> tags = new ArrayList<>();

        try {
            //1、获取数据库连接
            c = DBUtil.getConnection();
            //复制粘贴进来的代码：Ctrl+f替换所有的\n换行符，在需要空格的地方加上空格或tab缩进，设置占位符
            String sql  = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ?";
            //2、创建操作命令对象
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,key);
            //3、执行sql语句
            rs = ps.executeQuery();
            //4、处理查询结果集
            while (rs.next()){
                DictionaryTag tag = new DictionaryTag();
                //设置属性：通过结果集获取，并设置
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                tags.add(tag);
            }
            return tags;
        }catch (Exception e){
            throw new RuntimeException("查询数据字典标签出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }
}
