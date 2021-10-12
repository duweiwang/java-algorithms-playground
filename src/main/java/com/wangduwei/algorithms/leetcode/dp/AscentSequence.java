package com.wangduwei.algorithms.leetcode.dp;

/**
 * <p>最长递增子序列
 *
 * @author : wangduwei
 * @since : 2019/11/4  12:34
 **/
public class AscentSequence {

    /**
     * O(n^2)
     */
    public int findLongest(int[] A, int n) {
        //备忘录
        int[] c = new int[n];
        //找到以A[i]结尾的子串的最大值，放进C
        for (int i = 0; i < n; i++) {
            c[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i])//以A[i]结尾,必须要小于A[i]
                    c[i] = Math.max(c[j] + 1, c[i]);
            }
        }
        //在C中找到最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] > max) max = c[i];
        }
        return max;
    }
}
