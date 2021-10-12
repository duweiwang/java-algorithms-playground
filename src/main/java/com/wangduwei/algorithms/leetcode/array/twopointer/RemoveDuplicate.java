package com.wangduwei.algorithms.leetcode.array.twopointer;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * <p> 移除重复元素
 *
 * @author : wangduwei
 * @since : 2020/3/30  16:14
 **/
public class RemoveDuplicate extends BaseSortAlgorithms {

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5,6};
//        int[] nums = {};
       RemoveDuplicate.solution(nums);
        display(nums);
    }

    public static void solution(int[] array) {
        int i = 0;
        for (int j = 1; j < array.length; j++) {//快指针
            if (array[i] != array[j]) {//慢指针
                i++;
                array[i] = array[j];
            }
        }

    }

}
