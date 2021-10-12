package com.wangduwei.algorithms.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 遇到的问题：
 * map有{@link Map#containsKey(Object)} and {@link Map#containsValue(Object)} method
 * <ul>
 * <li>注意返回的两个值的顺序</li>
 * <li>注意无结果时返回的空数组</li>
 * </ul>
 */
public class _1_TwoSum {

    public static void main(String[] args) {
        int array[] = {2, 7, 11, 15};
        int a[] = new _1_TwoSum().twoSum(array, 9);
        System.out.println(a[0] + "," + a[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        //value-
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sub = target - num;
            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }
            map.put(num, i);
        }

        return new int[2];
    }

}
