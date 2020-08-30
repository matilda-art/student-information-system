package frank.dao;

import frank.model.Classes;
import org.junit.Test;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-30 10:27
 **/

public class ClassesDaoTest {

    @Test
    public void queryAsDict() {
        Classes classes = new Classes();
        classes.setId(1);
        classes.setClassesMajor("软件工程");
        classes.setClassesGraduateYear("2020届");
        classes.setClassesDesc("大班");
        classes.setClassesName("一班");
        classes.setCreateTime(null);
        classes.setDictionaryTagKey("数学");
        classes.setDictionaryTagValue("120");
        classes.setDictionaryId(12);
        classes.setDictionaryTagDesc("第一");
    }
}
