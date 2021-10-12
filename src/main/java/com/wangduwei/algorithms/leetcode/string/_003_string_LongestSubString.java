package com.wangduwei.algorithms.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>003-无重复字符的最长子串
 *
 * @author : wangduwei
 * @since : 2019/11/29  13:11
 **/
public class _003_string_LongestSubString {
    public static void main(String[] args) {
        int num = _003_string_LongestSubString.lengthOfLongestSubstring(" ");
        System.out.println(num);
    }

    /*理论就是双指针和集合操作*/
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i <= chars.length - 1; i++) {
            int max = 1;
            set.clear();
            set.add(chars[i]);
            for (int j = i + 1; j <= chars.length - 1; j++) {
                if (!set.contains(chars[j])) {
                    max++;
                    set.add(chars[j]);
                } else {
                    break;
                }
            }
            maxLength = maxLength > max ? maxLength : max;
        }
        return maxLength;
    }
}
