package com.wangduwei.algorithms.leetcode.string;

/**
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-69-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : wangduwei
 * @date : 2020/3/26
 * @description :
 */
public class Maximum69Number {

    /**
     * 字符数组和字符串的转换函数
     * @param num
     * @return
     */
    public static int maximum69Number(int num) {
        String stringNum = String.valueOf(num);
        char[] charArray = stringNum.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '9') continue;
            charArray[i] = '9';
            break;
        }
        return Integer.parseInt(String.valueOf(charArray));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9996));
    }

}
