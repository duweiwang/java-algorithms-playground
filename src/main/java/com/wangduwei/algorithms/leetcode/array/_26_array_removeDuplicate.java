package com.wangduwei.algorithms.leetcode.array;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组
 * 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author : wangduwei
 * @date : 2020/5/30
 * @description :
 */
public class _26_array_removeDuplicate {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }
}
