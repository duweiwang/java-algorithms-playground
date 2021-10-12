package com.wangduwei.algorithms.leetcode.array.binary;

/**
 * 有序数组的查找，先想二分法！！！
 * 有序数组缺失的元素
 * @author : wangduwei
 * @date : 2020/5/30
 * @description :
 */
public class _53_array_missingValueSorted {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15};
        int result = _53_array_missingValueSorted.missingNumber(array);
        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = (right + left) >>> 1;

            if (nums[middle] == middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        return left;
    }
}
