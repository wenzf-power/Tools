package Commons;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: wenzf
 * @Date 2021-8-6
 * @Description: StringUtils的使用场景
 */
public class TestDemo {
    public static void main(String[] args) {
        //首字母转大写
        String str = "wzfabc";
        String capitalize = StringUtils.capitalize(str);
        System.out.println(capitalize);

        // Date类型转String类型
        String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(date); // 输出 2021-05-01 01:01:01

        //StringUtils的字符串join连接
        String s = StringUtils.join("a", "b");
        System.out.println(s);

        //StringUtils的字符串spilt分割
        List<String> strings = Arrays.asList(StringUtils.split("hello,world", ","));
        System.out.println(strings);
    }
}
/**
 * 结果示例：
 *
 * Wzfabc
 * 2021-10-29 10:13:27
 * ab
 * [hello, world]
 */