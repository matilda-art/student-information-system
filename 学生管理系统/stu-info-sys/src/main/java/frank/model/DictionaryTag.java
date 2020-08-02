package frank.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据字典标签
 */
@Getter
@Setter
@ToString
public class DictionaryTag {

    //需要使用包装数据类型，因为new对象时，基本数据类型的默认值可能会出现问题
    private Integer id;

    /**
     * 键
     */
    private String dictionaryTagKey;

    /**
     * 值
     */
    private String dictionaryTagValue;

    /**
     * 备注
     */
    private String dictionaryTagDesc;

    /**
     * 数据字典id
     */
    private Integer dictionaryId;

    /**
     * 创建时间
     */
    //一般日期类型使用java.util.Date和数据库映射（默认的映射是java.sql.xxx）
    private Date createTime;
}