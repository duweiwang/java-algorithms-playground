package com.wangduwei.algorithms.leetcode.all_hand_up;

import java.util.HashMap;

/**
 * 两数之和，考察map的使用
 *
 * @author : wangduwei
 * @date : 2020/6/21
 * @description :
 */
public class tow_sum {
    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        tow_sum.twosum(array,9);
    }

    public static int[] twosum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int r = target - array[i];
            if (map.containsKey(r)) {
                return new int[]{map.get(r), i};
            }
            map.put(array[i],i);
        }

        return new int[]{0, 0};
    }


}
