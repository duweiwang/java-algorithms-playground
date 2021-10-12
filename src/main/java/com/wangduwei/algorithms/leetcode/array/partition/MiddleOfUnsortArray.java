package com.wangduwei.algorithms.leetcode.array.partition;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * <p>无序数组的中位数
 *
 * @author : wangduwei
 * @since : 2020/4/9  17:51
 **/
public class MiddleOfUnsortArray extends BaseSortAlgorithms {

    public static void main(String[] args) {
        int[] array = {1, 5, 6, 9, 7, 4, 3, 6, 8, 1, 5, 9, 7, 0, 5, 7};
        double result = MiddleOfUnsortArray.median2(array);
        System.out.print(result);
    }

    public static double median2(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int left = 0, right = array.length - 1;
        int midIndex = right >> 1;

        int index = -1;
        while (index != midIndex) {
            index = partition(array, left, right);
            if (index < midIndex)
                left = index + 1;
            else if (index > midIndex)
                right = index - 1;
            else break;
        }
        return array[index];
    }

    public static int partition(int[] array, int left, int right) {
        if (left > right) return -1;
        int pos = right;
        right--;
        while (left <= right) {
            while (left < pos && array[left] <= array[pos])
                left++;
            while (right > left && array[right] > array[pos])
                right--;
            if (left >= right) break;
            swap(array, left, right);
        }

        swap(array, left, pos);
        return left;
    }
}
