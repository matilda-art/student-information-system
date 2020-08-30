package frank.dao;

import frank.model.DictionaryTag;
import org.junit.Test;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-30 10:31
 **/
public class DictionaryTagDaoTest {

    @Test
    public void query() {
        DictionaryTag dictionaryTag = new DictionaryTag();
        dictionaryTag.setId(12);
        dictionaryTag.setDictionaryTagValue("111");
        dictionaryTag.setDictionaryTagKey("语文");
        dictionaryTag.setCreateTime(null);
        dictionaryTag.setDictionaryId(22);
        dictionaryTag.setDictionaryTagDesc("第二");
    }
}
