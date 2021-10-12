package com.wangduwei.algorithms.leetcode.array;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author : wangduwei
 * @date : 2020/4/10
 * @description :
 */
public class MaxValue2TimesOther {


    /**
     * 只要满足第二大的数是第一大数的两倍就行了
     *
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        int max1 = -1;
        int max2 = -1;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= 2 * max2 ? maxIndex : -1;
    }

}
