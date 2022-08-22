package Guava.Map;

import com.google.common.collect.ArrayListMultimap;

/**
 * @Author: wenzf
 * @Date 2021-7-28
 * @Description:一键多值类Multimap
 */
public class MultimapDemo {
    public static void main(String[] args) {
        ArrayListMultimap<Integer, String> multimap = ArrayListMultimap.create();
        multimap.put(1, "abc");
        multimap.put(1, "qwe");
        multimap.put(2, "asd");
        multimap.put(2, "awe");
        for (Integer i: multimap.keySet()) {
            System.out.println(i+":"+multimap.get(i));
        }
        System.out.println(multimap.size());
    }
}
/**
 * 结果示例：
 * 1:[abc, qwe]
 * 2:[asd, awe]
 * 4
 */
