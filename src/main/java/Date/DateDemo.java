package Date;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @Author: wenzf
 * @Date 2022-1-19
 * @Description: 日期后推
 */
public class DateDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = sdf.format(date);//date-->String
        System.out.println(stringDate);
        //下面这四行是重要的，将date日期加1
        int i = Integer.parseInt("1");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);//日期向后+1天，整数往后推，负数向前推
        date = calendar.getTime();//这个时间就是日期向后推一天的结果
        stringDate = sdf.format(date);//date-->String
        System.out.println(stringDate);
    }
}
/**
 * 结果示例：
 * 2022-02-09
 * 2022-02-10
 */
