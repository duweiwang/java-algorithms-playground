package com.wangduwei.algorithms.leetcode.array.find;

/**
 * 找出数组中超过一半的那个数
 *
 * @author : wangduwei
 * @date : 2020/5/6
 * @description :
 */
public class FindMoreThanHalf {

    public int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                elem = nums[i];
                count = 1;
            } else {
                if (elem == nums[i])
                    count++;
                else
                    count--;
            }

        }
        return elem;
    }
}
