package com.wangduwei.algorithms.leetcode.array.binary;

/**
 * <p>数组元素都是成对的，只有一个成单，有序数组！
 * 找出单个元素,要求log(n)
 *
 * <p>异或操作解决
 * {@link com.wangduwei.algorithms.bit.BitCompute#singleNumber}
 *
 * @author : wangduwei
 * @since : 2020/5/15  10:48
 **/
public class ArraySingleElement {

    public static void main(String[] args) {
        int test[] = {1, 1, 3, 3, 5, 5, 7, 7, 8, 8, 9, 9, 44, 44, 55};
//        int result = ArraySingleElement.singleNonDuplicate(test);
        int result = ArraySingleElement.singleNonDuplicate2(test);
        System.out.print(result);
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            boolean pair = (right - mid) % 2 == 1;
            if (nums[mid + 1] == nums[mid]) {
                if (!pair) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (!pair) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[left];
    }

    /*只判断偶数位*/
    public static int singleNonDuplicate2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
