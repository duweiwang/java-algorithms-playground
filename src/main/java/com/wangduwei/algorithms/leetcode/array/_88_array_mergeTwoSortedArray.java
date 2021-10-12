package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 *
 * @author : wangduwei
 * @date : 2020/5/28
 * @description :
 */
public class _88_array_mergeTwoSortedArray {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,0,0,0,0,0};
        int[] b = {2,4,6,8,10};
        _88_array_mergeTwoSortedArray.merge(a,5,b,5);
        AlgorithmCommon.printArray(a);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while (i >= 0) {
            nums1[index] = nums1[i];
            i--;
            index--;
        }
        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }
}
