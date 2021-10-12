package com.wangduwei.algorithms.bitmap;

import org.junit.Test;

/**
 * <p>
 *
 * @author : wangduwei
 * @since : 2020/4/15  14:02
 **/
public class BitmapTest {

    /**
     * 按大小顺序打印正整数数组{7, 2, 13, 1, 55, 78, 99, 66, 0, 33, 45, 71, 85}，注意要求O(n)
     */
    @Test
    public void test_1() {
        int capacity = 100;
        BitMap bitMap = new BitMap(100);    // 简单实现没有自动扩容，需要指定容量
        bitMap.add(7, 2, 13, 1, 55, 78, 99, 66, 0, 33, 45, 71, 85);    // 这一步是O(n)的
        for (int i = 0; i < capacity; i++) {    // 遍历也是O(n)的
            if(bitMap.contains(i)) {
                System.out.print(i+", ");
            }
        }
        System.out.println(); // out: 0, 1, 2, 7, 13, 33, 45, 55, 66, 71, 78, 85, 99,
    }

    /**
     * 找到正整数数组{7, 2, 13, 1, 55, 78, 99, 66, 0, 33, 45, 71, 85}中未出现的最小整数3，注意要求O(n)
     */
    @Test
    public void test_2() {
        int capacity = 100;
        BitMap bitMap = new BitMap(100);
        bitMap.add(7, 2, 13, 1, 55, 78, 99, 66, 0, 33, 45, 71, 85);    // 这一步是O(n)的
        for (int i = 0; i < capacity; i++) {    // 遍历也是O(n)的
            if(!bitMap.contains(i)) {
                System.out.println(i);
                break;
            }
        } // out: 3
    }
}
