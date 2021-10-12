package com.wangduwei.algorithms.leetcode.array;

import java.util.Arrays;

/**
 * <p>两个有序数组 找到中位数
 *
 * @author : wangduwei
 * @since : 2019/11/29  15:53
 **/
public class _4_MiddleOfTwoOrderArray {

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        double result = _4_MiddleOfTwoOrderArray.findMedianSortedArrays(a, b);
        System.out.println(result);
    }

    /**
     * 两个数组放入一个数组，排序，
     * Log(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = m + n;
        int[] merge = new int[length];
        int i = 0;
        while (i < length) {
            if (i < m) {
                merge[i] = nums1[i];
            } else {
                merge[i] = nums2[i - m];
            }
            i++;
        }
        Arrays.sort(merge);
        if (length % 2 == 1) {
            return merge[length / 2];
        } else {
            return (1.0 * merge[length / 2] + 1.0 * merge[length / 2 - 1]) / 2;
        }
    }
}
