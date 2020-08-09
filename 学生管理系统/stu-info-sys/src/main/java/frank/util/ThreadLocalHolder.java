package frank.util;

/**
 * @program: 学生管理系统
 * @description
 * @author: matilda
 * @create: 2020-08-09 21:08
 **/

//线程本地变量保存的功能
public class ThreadLocalHolder {

    //一般情况下，需要 ThreadLocal 的生命周期很长，所以将其定义成一个静态的变量
    private static ThreadLocal<Integer> TOTAL = new ThreadLocal<>();

    public static ThreadLocal<Integer> getTOTAL() {
        return TOTAL;
    }
}
