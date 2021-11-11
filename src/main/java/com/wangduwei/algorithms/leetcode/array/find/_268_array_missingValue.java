package com.wangduwei.algorithms.leetcode.array.find;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
 * 找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 思路：合理利用数组的角标
 *
 * @author : wangduwei
 * @date : 2020/5/31
 * @description :
 */
public class _268_array_missingValue {

    /**
     * （0 ~ n）一共N-1个数字，数组中放进去n个，[0 ~ n-1]
     * 那么少的那个是谁？
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int missing = nums.length;//假装少的是最后一个数

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];//角标和值碰掉
        }

        return missing;
    }

}
