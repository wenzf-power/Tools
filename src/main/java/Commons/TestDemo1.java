package Commons;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.Date;

/**
 * @Author: wenzf
 * @Date 2021-8-9
 * @Description:
 */
public class TestDemo1 {
    public static void main(String[] args) {
        //返回两个字段
        ImmutablePair<Integer, String> pair = ImmutablePair.of(1, "wzf");
        System.out.println((pair.getLeft() + ","+pair.getRight()));

        //返回三个字段
        ImmutableTriple<Integer, String, Date> triple = ImmutableTriple.of(1, "abc", new Date());
        System.out.println((triple.getLeft() + "," + triple.getMiddle() + "," + triple.getRight()));
    }
}
/**
 * 结果示例：
 *
 * 1,wzf
 * 1,abc,Fri Oct 29 10:14:23 CST 2021
 */
