package com.wangduwei.algorithms.bit;


/**
 * <p>算法中的位运算。
 * <p></>
 *
 * @author : wangduwei
 * @since : 2020/5/27  13:56
 **/
public class BitCompute {
    public static void main(String[] args) {

        int sum = getSum(999, 1000);
        System.out.print(sum);

        boolean result = isPowerOfTwo(16);
        System.out.print("\n16 = " + result + ",5 = " + isPowerOfTwo(5));

        int single = singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5});
        System.out.print("\nsingle num is = "+single);

        System.out.printf("\nnumber of one = " + getNumOfOneInBinary(3));
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

    /**
     * 求二进制中有多少个1
     * @param n
     * @return
     */
    public static int getNumOfOneInBinary(int n){
        int count = 0;
        while (n >0 ) {
            count ++;
            n &= (n-1);
        }
        return count;
    }

    //7 = 000111     7 = 000111   6 = 000110
    //1 = 000001     6 = 000110   5 = 000101
    //& = 000001     & = 000110   & = 000100
    //                  //结论：n & (n-1)会消掉n的一个1。n & (n-1) = (n-2)


    /**
     * 判断一个数是否是2的方幂
     * @param n
     * @return
     */
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 找出数组中不成对的那个数
     * 异或操作，都是成对的，只有一个成单的
     * @param nums 数组元素
     * @return 不成对的数
     */
    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
