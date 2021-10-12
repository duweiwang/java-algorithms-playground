package com.wangduwei.algorithms.leetcode.all_hand_up;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : wangduwei
 * @date : 2020/6/21
 * @description :
 */
public class add_array_int {

    public static void main(String[] args) {
        int[] a ={2,7,4};
        add_array_int.add(a,181);
    }

    public static List<Integer> add(int[] array, int i) {
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();
        for (int j = array.length - 1; j >= 0; j--) {
            int k = array[j] + i % 10 + carry;

            if (k > 9) {
                carry = 1;
                result.addFirst(k % 10);
            } else {
                carry = 0;
                result.addFirst(k);
            }
            i /= 10;
        }
        if(carry > 0){
            result.addFirst(carry);
        }
        return result;
    }
}
