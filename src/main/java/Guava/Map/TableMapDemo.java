package Guava.Map;

import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * @Author: wenzf
 * @Date 2021-8-9
 * @Description:Table 一种有两个key的HashMap
 */
public class TableMapDemo {
    public static void main(String[] args) {
        HashBasedTable<Integer, String, String> table = HashBasedTable.create();
        table.put(18, "男", "wzf");
        table.put(18, "女", "abc");
        System.out.println(table.get(18, "男"));
        //查看行数据
        Map<String, String> row = table.row(18);
        System.out.println(row);
        //查看列数据
        Map<Integer, String> column = table.column("男");
        System.out.println(column);
    }
}

/**
 * 结果示例：
 * wzf
 * {男=wzf, 女=abc}
 * {18=wzf}
 */

