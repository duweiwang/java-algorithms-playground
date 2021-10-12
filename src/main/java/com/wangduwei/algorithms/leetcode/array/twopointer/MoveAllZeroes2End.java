package com.wangduwei.algorithms.leetcode.array.twopointer;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * 把0全部移到数组最后
 */
public class MoveAllZeroes2End extends BaseSortAlgorithms {
    public static void main(String[] args) throws Exception {
        int[] nums = {0, 0, 0, 0, 1, 0, 3, 0, 2};
//        new MoveZeroes().moveZeroes(nums);
        new MoveAllZeroes2End().moveZeroToEnd(nums);
        display(nums);
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) j++;
            else {
                swap(nums, i, j);
                i++;
                j++;
            }
        }
        while (i < nums.length) nums[i++] = 0;
    }

    /*随手一写*/
    public void moveZeroToEnd(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            swap(nums,i,j);
            j++;
        }

    }
}
