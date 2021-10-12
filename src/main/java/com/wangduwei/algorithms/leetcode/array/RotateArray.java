package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * 将数组右移n位
 */
public class RotateArray extends BaseSortAlgorithms {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        new RotateArray().rotate(A, 5);
        for (int i : A) System.out.print(i + " ");
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;//右移数组的长度等于没有移动
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int s, int e) {
        for (int i = s, j = e; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
}
