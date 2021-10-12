package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * @author : wangduwei
 * @date : 2020/5/28
 * @description :
 */
public class _75_array_colorSort {
    public static void main(String[] args) {
//        int[] value = {2,0,2,1,1,0};
//        int[] value = {0, 0};
//        int[] value = {2, 1};
        int[] value = {1, 0, 0};
        _75_array_colorSort.sortColorsLT(value);
        AlgorithmCommon.printArray(value);
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sortColorsLT(int[] nums) {
        int left = 0, right = nums.length;
        if (right < 2) return;

        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                right--;
                swap(nums, i, right);
            }
        }
    }

}
