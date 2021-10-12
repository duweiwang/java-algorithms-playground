package com.wangduwei.algorithms.leetcode.array.find;

/**
 * <p> 找到数组中第三大的数 Log(n)
 *
 * @auther : wangduwei
 * @since : 2019/10/28  16:24
 **/
public class FindThirdMaxValue {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().thirdMax(new int[]{2, 2, 3, 1}));
        }

        public int thirdMax(int[] nums) {
            Integer maxOne = null;
            Integer maxTwo = null;
            Integer maxThree = null;
            for (Integer i : nums) {
                if (i.equals(maxOne) || i.equals(maxTwo) || i.equals(maxThree)) {
                    continue;
                }
                if (maxOne == null || i > maxOne) {
                    maxThree = maxTwo;
                    maxTwo = maxOne;
                    maxOne = i;
                } else if (maxTwo == null || i > maxTwo) {
                    maxThree = maxTwo;
                    maxTwo = i;
                } else if (maxThree == null || i > maxThree) {
                    maxThree = i;
                }
            }
            return maxThree != null ? maxThree : maxOne;
        }
    }

    static class Solution2{
        public int thirdMax(int[] nums) {
            long[] max = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
            int count = 0;
            for (int num : nums) {
                for (int j = 0; j < 3; j++) {
                    if (max[j] > num) continue;
                    else if (max[j] == num) break;
                    int k = j;
                    long temp1, temp2;
                    temp1 = num;
                    count++;
                    while (k < 3) {
                        temp2 = max[k];
                        max[k] = temp1;
                        temp1 = temp2;
                        k++;
                    }
                    break;
                }
            }
            System.out.println(Integer.MIN_VALUE);
            return (count >= 3) ? (int) max[2] : (int) max[0];
        }
    }

}
