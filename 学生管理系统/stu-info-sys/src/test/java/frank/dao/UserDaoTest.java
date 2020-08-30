package frank.dao;

import frank.model.User;
import org.junit.Test;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-30 10:04
 **/

public class UserDaoTest {

    @Test
    public void query() {
        User user = new User();
        user.setId(1);
        user.setUsername("楚舟寒");
        user.setPassword("123");
        user.setNickname("matilda");
        user.setEmail("123");
        user.setCreateTime(null);
    }
}
