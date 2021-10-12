package com.wangduwei.algorithms.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [剑指offer]-数组元素全排列组成的最小值,本质是上一个字典排序
 *
 * @author : wangduwei
 * @date : 2020/5/2
 * @description :
 */
public class offer_45_Array2MinValue {

    public static void main(String[] args) {
        int[] array = {71, 66, 111, 23};
        String result = offer_45_Array2MinValue.PrintMinNumber2(array);
        System.out.print(result);
    }

    //求全排列，然后选出最小的


    //选择排序进行优化==？
    public static String PrintMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        //全部转换成字符串处理
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }
        return sb.toString();
    }

    //待定---

    //https://blog.csdn.net/dawn_after_dark/article/details/81256350


    //----------------leet-code
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    void fastSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }
}
