package com.wangduwei.algorithms.leetcode.array.basic;

/**
 * 寻找数组的中心索引（左右两边的值相等）
 *
 * @author : wangduwei
 * @date : 2020/4/10
 * @description :
 */
public class ArrayCenterIndex {

    public static void main(String[] args) {
        int[] array = {1, 7, 3, 6, 5, 6};

        ArrayCenterIndex.leetCodeSolution(array);
    }

    public static int leetCodeSolution(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int n : nums)
            sum += n;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
