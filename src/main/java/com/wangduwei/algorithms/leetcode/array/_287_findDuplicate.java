package com.wangduwei.algorithms.leetcode.array;


/**
 * 给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 *
 * @author : wangduwei
 * @date : 2020/4/12
 * @description :
 */
public class _287_findDuplicate {

    /**
     * 1、数组坐标和值进行映射，形成链表
     * 2、存在重复值，链表有环
     * 3、快慢指针定位环的入口
     *
     * @param nums
     * @return
     */
    public static int findDuplicated(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

}
