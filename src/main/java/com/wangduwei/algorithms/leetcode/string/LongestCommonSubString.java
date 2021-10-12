package com.wangduwei.algorithms.leetcode.string;

/**
 * @author : wangduwei
 * @date : 2020/5/6
 * @description :
 */
public class LongestCommonSubString {

    /**
     * 最长公共子串
     */
    int longestPublicSubstring(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] val = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i >= 1 && j >= 1) {
                        val[i][j] = val[i - 1][j - 1] + 1;
                    } else {
                        val[i][j] = 1;
                    }
                } else {
                    val[i][j] = 0;
                }
            }
        }
        // 找到val数组中的最大值
        int max = 0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                max = Math.max(val[i][j], max);
            }
        }
        return max;
    }
}
