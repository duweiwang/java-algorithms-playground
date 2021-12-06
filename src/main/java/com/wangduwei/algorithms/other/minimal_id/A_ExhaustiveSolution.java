package com.wangduwei.algorithms.other.minimal_id;

/**
 * 暴力解法，复杂度O（n2）
 */
public class A_ExhaustiveSolution {

    /**
     * 从1开始，判断数字是否在数组中
     * @param arr
     * @return
     */
    static int find1(int[] arr) {
        int i = 1;   //i从1开始
        while (true) {
            if (indexOf(arr, i) == -1) {   //找到没有的那个数返回
                return i;
            }
            i++;  //若不是，继续循环
        }
    }

    static int indexOf(int[] arr, int i) {  //声明方法
        return i;
    }

}
