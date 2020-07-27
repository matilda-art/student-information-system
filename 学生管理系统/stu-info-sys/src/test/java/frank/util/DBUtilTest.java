package frank.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @program: rocket2
 * @description
 * @author: matilda
 * @create: 2020-07-27 15:14
 **/
public class DBUtilTest {
    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
