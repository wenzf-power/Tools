package Guava.Set;

import com.google.common.collect.HashMultiset;

import java.util.Iterator;
import java.util.Set;

/**
 * @Author: wenzf
 * @Date 2021-8-9
 * @Description:Multiset 一种用来计数的Set
 */
public class MultisetDemo {
    public static void main(String[] args) {
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("orange");
        System.out.println(multiset.count("apple"));//查看重复的次数
        //查看去重后的元素
        Set<String> set = multiset.elementSet();
        System.out.println(set);

        //查看没有去重之前的元素
        Iterator<String> iterator = multiset.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //手动设置某个元素的出现次数
        multiset.setCount("apple", 5);
        System.out.println(multiset);
        Iterator<String> iterator1 = multiset.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
/**
 * 运行结果示例：
 * 2
 * [orange, apple]
 * orange
 * apple
 * apple
 * [orange, apple x 5]
 * orange
 * apple
 * apple
 * apple
 * apple
 * apple
 */
