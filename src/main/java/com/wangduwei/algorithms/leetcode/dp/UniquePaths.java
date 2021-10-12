package com.wangduwei.algorithms.leetcode.dp;

/**
 * <p>机器人在左上角，只能向右向下移动，到达右下角有多少种走法
 * <p>
 * 三种实现方式：
 * 当到达（m,n）位置时，只能从（m-1,n）或（m.n-1）过来。
 * 递推公式 ：dp[m][n] = dp[m-1][n] + dp[m][n-1]
 * 边界条件：
 * 1、当处于第一行或第一列时，即dp[0][n]或dp[m][0]只能有1种方法到达。
 * 2、dp[0][0] = 0;
 *
 * @author : wangduwei
 * @since : 2019/11/6  12:30
 **/
public class UniquePaths {
    /**
     * 递归实现
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化为-1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return robot(m - 1, n - 1, dp);
    }

    public int robot(int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 1;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        dp[m][n] = robot(m - 1, n, dp) + robot(m, n - 1, dp);
        return dp[m][n];
    }

    /**
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[j] = 1;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
