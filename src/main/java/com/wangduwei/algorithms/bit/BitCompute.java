package com.wangduwei.algorithms.bit;

import org.junit.Test;

/**
 * <p>bit compute in algorithm
 *
 * @author : wangduwei
 * @since : 2020/5/27  13:56
 **/
public class BitCompute {
    public static void main(String[] args) {

        int sum = getSum(999, 1000);
        System.out.print(sum);

        boolean result = isPowerOfTwo(16);
        System.out.print("16 = " + result + ",5 = " + isPowerOfTwo(5));
    }

    /**
     * 位运算：
     * 异或操作 = 无进位加法
     * 与运算 + 左移 = 进位
     * https://leetcode-cn.com/problems/sum-of-two-integers/solution/wei-yun-suan-xiang-jie-yi-ji-zai-python-zhong-xu-y/
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }


    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    //异或操作，都是成对的，只有一个成单的
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    @Test
    public void testSingleNum(){
        int result = singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5});
        System.out.print(result);
    }
}
