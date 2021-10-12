package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;

import java.util.LinkedList;
import java.util.List;

/**
 * <p> int array add int
 * Leetcode-989=数组形式的整数加法
 *
 * @auther : wangduwei
 * @since : 2019/10/28  11:00
 **/
public class _989_AddArryAndInteger {

    public static void main(String[] args) {
        int[] array = {1,2,3,0,0};
        List<Integer> list = _989_AddArryAndInteger.addToArrayForm(array,45);
        AlgorithmCommon.printSingleJavaList(list);//1, 2, 3, 4, 5,
    }

    public static List<Integer> addToArrayForm(int[] array, int num) {
        LinkedList<Integer> ret = new LinkedList<>();

        int i = array.length - 1;
        while (i >= 0 || num > 0) {
            if (i >= 0) {
                num += array[i];
            }
            ret.addFirst(num % 10);
            num /= 10;
            i--;
        }

        return ret;

    }

}
