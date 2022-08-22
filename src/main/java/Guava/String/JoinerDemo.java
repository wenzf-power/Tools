package Guava.String;

import com.google.common.base.Joiner;

/**
 * @Author: wenzf
 * @Date 2021-7-28
 * @Description:字符串连接器
 */
public class JoinerDemo {
    public static void main(String[] args) {
        //连接多个字符串
        StringBuilder builder = new StringBuilder("hello");
        // 字符串连接器，以|为分隔符，同时去掉null元素
        Joiner joiner = Joiner.on("|").skipNulls();
        builder = joiner.appendTo(builder,"er","dd",null,"abc");
        System.out.println(builder);
    }
}
/**
 * 运行结果示例：
 * helloer|dd|abc
 */
