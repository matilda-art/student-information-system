package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-09 19:55
 **/

@Getter
@Setter
@ToString
public class Page {
    private String searchText;//条件查询的字段
    private String sortOrder;//排序的条件
    private Integer pageSize;//每页的数量
    private Integer pageNumber;//当前的页码

    public static Page parse(HttpServletRequest req){
        Page p = new Page();
        p.searchText = req.getParameter("searchText");
        p.sortOrder = req.getParameter("sortOrder");
        p.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        p.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return p;
    }
}
