package com.wangduwei.algorithms.leetcode.array.basic;


/**
 * Leetcode[数组集合]：数组加一,考虑进位！！！
 *
 * @author : wangduwei
 * @date : 2020/5/14
 * @description :
 */
public class ArrayAddOne {
    public static void main(String[] args) {
        int[] array = {9, 9, 9, 9, 9};
        new ArrayAddOne().plusOne(array);
    }

    //********Leet-code*********
    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
//-----------------------------------------------
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];

        for (int i = digits.length - 1; i >= 0; i--) {
            boolean r = addOne(digits, result, i);
            if (!r) {
                break;
            }
            if (r && i == 0) {
                result[0] = 1;
            }
        }
        if (result[0] == 1) {
            return result;
        }
        return digits;
    }

    public boolean addOne(int[] digits, int[] result, int i) {
        if (digits[i] + 1 > 9) {
            result[i + 1] = 0;
            digits[i] = 0;
            return true;
        } else {
            result[i + 1] = digits[i] + 1;
            digits[i] += 1;
            return false;
        }
    }

}
