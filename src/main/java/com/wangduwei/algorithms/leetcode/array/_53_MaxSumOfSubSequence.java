package com.wangduwei.algorithms.leetcode.array;

/**
 * <p>最大连续子数组的和
 *
 * @author : wangduwei
 * @since : 2020/5/19  9:58
 **/
public class _53_MaxSumOfSubSequence {
    public static void main(String[] args) {
        int arr[] = {2, -3, 4, 11, -5, 8, 3, -6};
        int maxSum = getMaxSum2(arr);
        int maxSum2 = getMaxSum(arr);
        int maxSum3 = maxSubArray(arr);
        System.out.println("最大子数组的和为：" + maxSum + ",maxSum2=" + maxSum2 + ",maxSum3=" + maxSum3);
    }

    /**
     * https://leetcode-cn.com/problems/contiguous-sequence-lcci/solution/fen-zhi-fa-by-xiang-ri-kui-40/
     * 好理解的动态规划
     */
    public int maxSubArrayGood(int[] nums) {
        int b = nums[0];
        int sum = b;
        for (int i = 1; i < nums.length; i++) {
            if (b < 0) {
                b = nums[i];
            } else {
                b += nums[i];
            }
            if (b > sum) {
                sum = b;
            }
        }
        return sum;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    /**
     * 方法一：暴力枚举
     * 定义一个最大值max初始化一个很小的数，定义一个变量sum表示求和值，
     * 遍历数组元素，从第一个元素开始，依次相加，如果和sum比最大值max大就将sum赋值给最大值。
     * 然后再来一个循环控制从第i个数组元素开始求和，直到n.
     * 时间复杂度:O(n^2)
     *
     * @param arr
     * @return
     */
    private static int getMaxSum(int[] arr) {
        int max = -100000;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    /**
     * 方式二：贪心法
     * 因为每次求和都是将i前面的元素相加，会出现重复的情况，
     * 如果出现相加完之后是负数，说明这时我就要继续遍历找到第一个正数，
     * 将前面的和为负数的元素全部丢掉。如果找不到正数，那现在的值max就是最大值。
     * 时间复杂度：O(n)
     *
     * @param arr
     * @return
     */
    private static int getMaxSum2(int[] arr) {
        int length = arr.length;
        int max = -1000000;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                max = 0; // 子串和为负数，丢掉
            }
        }
        return max;
    }
}
