package com.wangduwei.algorithms.other.minimal_id;

import java.util.Arrays;

/**
 * 排序后求解,复杂度O(nlogn)
 */
public class B_SortSolution {

    int find2(int[] arr) {
        Arrays.sort(arr);   //对数组进行排序
        int i = 0;     //数组下标从0开始  ，i为数组下标
        while (i < arr.length) {
            if (i + 1 != arr[i]) {    //当数组下标和对应的数不匹配时
                return i + 1;  //返回对应缺少的数
            }
            i++;  //否则，继续循环
        }
        return i + 1;
    }
}
