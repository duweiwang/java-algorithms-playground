package com.wangduwei.algorithms.leetcode.array;

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * @author : wangduwei
 * @date : 2020/5/30
 * @description :
 */
public class _1343_array_averageSubArray {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int num = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int average = getArrayAverage(arr,i,i+k);
            if (average >= threshold){
                num++;
            }
        }
        return num;
    }


    private int getArrayAverage(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum / (end - start);
    }

}
