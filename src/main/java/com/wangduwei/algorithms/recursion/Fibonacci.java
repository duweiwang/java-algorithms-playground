package com.wangduwei.algorithms.recursion;


/**
 * 斐波那契数列的递归过程，使用备忘录保存中间结果
 */
public class Fibonacci {
    int fibonacci(int n, int[] memo) {
        if (0 == n || 1 == n) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        } // 看来备忘录中找到了之前计算的结果，既然找到了，直接返回，避免重复计算

        if (n > 1) {
            memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
            return memo[n];
        }

        return 0; // 如果数值无效(比如 < 0)，则返回0
    }

    int fibonacciAdvance(int n) {
        int[] memo = new int[n + 1];
        return fibonacci(n, memo);
    }
}
