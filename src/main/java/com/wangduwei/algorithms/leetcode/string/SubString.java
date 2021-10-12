package com.wangduwei.algorithms.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author : wangduwei
 * @date : 2020/6/12
 * @description :
 */
public class SubString {


    @Test
    public void testLengthOfLongestSubstringSlidingWindow(){
        int result = lengthOfLongestSubstringSlidingWindow("abcabcbb");
        System.out.print(result);
    }

    /**
     * 这个基于滑动窗口实现，稍微好理解一点
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        //使用HashSet作为滑动窗口,找出无重复字符的最长子串。
        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0, right = 0;//i为滑动窗口的左边，j为右边
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {//如果没有重复
                set.add(s.charAt(right++));
                ans = Math.max(ans, right - left);
            } else {//如果出现重复
                set.remove(s.charAt(left++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        int length = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstringMe(s);
    }

    /**
     * 这个是我自己实现的，复杂度有点高
     */
    public static int lengthOfLongestSubstringMe(String s) {
        int maxL = 1;
        char[] chars = s.toCharArray();
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            map.add(chars[i]);
            int max = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (!map.contains(Character.valueOf(chars[j]))) {
                    max++;
                    map.add(Character.valueOf(chars[j]));
                } else {
                    break;
                }
            }
            maxL = Math.max(maxL, max);
            map.clear();
        }

        return maxL;
    }
}
