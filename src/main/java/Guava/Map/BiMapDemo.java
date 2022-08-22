package Guava.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @Author: wenzf
 * @Date 2021-8-9
 * @Description:BiMap 一种连Value也不能重复的HashMap
 */
public class BiMapDemo {
    public static void main(String[] args) {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("key", "value");
        System.out.println(biMap);
        //key,value 反转
        BiMap<String, String> inverse = biMap.inverse();
        System.out.println(inverse);
    }
}
/**
 * 结果示例：
 * {key=value}
 * {value=key}
 */
