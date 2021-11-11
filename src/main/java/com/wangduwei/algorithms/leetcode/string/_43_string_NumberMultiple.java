package com.wangduwei.algorithms.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 两数相乘,LeetCode 43
 *
 * @author : wangduwei
 * @since : 2020/3/30  12:50
 **/
public class _43_string_NumberMultiple {

    public static void main(String[] args) {
        String result = _43_string_NumberMultiple.solution("123", "456");
        System.out.print("result = " + result);
    }

    public static String solution(String numOne, String numTwo) {
        char[] numOneChar = numOne.toCharArray();
        char[] numTwoChar = numTwo.toCharArray();

        int oneLength = numOneChar.length;
        int twoLength = numTwoChar.length;

        int loop = oneLength > twoLength ? twoLength : oneLength;
        char[] longChar = oneLength > twoLength ? numOneChar : numTwoChar;
        char[] shortChar = oneLength > twoLength ? numTwoChar : numOneChar;

        List<char[]> list = new ArrayList<>();

        for (int i = loop; i > 0; i--) {
            list.add(multiple(longChar, shortChar[i]));
        }

        char[] result = null;
        for (int i = 0; i < list.size(); i++) {
            result = add(result, list.get(i));
        }

        return String.valueOf(result);
    }

    public static int char2int(Character character) {
        return character - '0';
    }

    private static char[] multiple(char[] numOne, char numTwo) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = numOne.length; i > 0; i--) {
            int result = char2int(numOne[i]) * char2int(numTwo);
            if (carry > 0) {
                result += carry;
            }
            carry = result / 10;

            if (result > 9) {
                sb.append(result % 10);
            } else {
                sb.append(result);
            }
        }
        if (carry > 0) {
            sb.append(carry);
        }

        return sb.toString().toCharArray();
    }

    private static char[] add(char[] one, char[] two) {
        int loop = one.length > two.length ? two.length : one.length;
        int carry = 0;
        for (int i = loop; i > 0; i--) {
            int result = char2int(one[i]) + char2int(two[i]);

            // TODO: 2020/3/30

        }
        return null;
    }
}
