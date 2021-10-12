package com.wangduwei.algorithms.leetcode.string;

/**
 * NO.14-最长公共前缀
 *
 * @author : wangduwei
 * @date : 2020/5/2
 * @description :
 */
public class _014_string_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"acvxx", "axc", "aaa"};
        System.out.println(longestCommonPrefix(s));//a

        System.out.println("abcdef".indexOf("abc"));//0
        System.out.println("abcdef".indexOf("ef"));//4
    }

    /*以0号元素为基准，逐渐缩短0号元素的长度*/
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //前缀，一定要以此开头，返回0
            while (strs[i].indexOf(pre) != 0)  // 字符串String的indexOf方法使用
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}
