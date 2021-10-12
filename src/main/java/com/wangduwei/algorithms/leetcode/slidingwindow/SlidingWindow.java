package com.wangduwei.algorithms.leetcode.slidingwindow;

import org.junit.Test;

/**
 * 滑动窗口算法
 * 1、给一组大小为n的整数数组，计算长度为k的子数组的最大值（窗口固定）
 *
 * @author : wangduwei
 * @date : 2020/6/15
 * @description :
 */
public class SlidingWindow {
    public static int maxNum(int[] array, int k) {
        if (array.length < k) {//如果k比数组长度还大，返回-1
            return -1;
        }
        int left = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += array[i];
        }
        int tempsum = sum;//tempsum记录每个窗口的总和
        while (left + k < array.length) {
            tempsum = tempsum - array[left] + array[left + k];
            left++;
            sum = Math.max(sum, tempsum);//sum取原sum和tempsum的较大值
        }
        return sum;
    }

    @Test
    public void maxNumTest() {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 3;
        System.out.println(maxNum(arr, k));
    }
}
