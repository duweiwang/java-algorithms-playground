package com.wangduwei.algorithms.leetcode.all_hand_up;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;

/**
 * <p>数组加一
 *
 * @author : wangduwei
 * @since : 2020/7/15  16:28
 **/
class array_add_one {


    public static void main(String[] args) {
//        int[] num = {9,9,9};
        int[] num = {1,1,1};
        int[] result = add_one(num);
        AlgorithmCommon.printArray(result);
    }


    public static int[] add_one(int[] array) {
        int last = array.length - 1;

        while (last >= 0) {
            int sum = array[last] + 1;
            if (sum < 9) {
                array[last] = sum;
                return array;
            }
            array[last--] = 0;
        }
        int[] temp = new int[last + 2];
        temp[0] = 1;
        return temp;
    }
}
