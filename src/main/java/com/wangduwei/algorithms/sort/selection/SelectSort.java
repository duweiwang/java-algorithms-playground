package com.wangduwei.algorithms.sort.selection;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

public class SelectSort extends BaseSortAlgorithms {

    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param numbers
     */
    public static void sort(int[] numbers) {
        int size = numbers.length; //数组长度

        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置,标记最小值的坐标
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            swap(numbers, i, k);
        }
    }

    public static void main(String[] args) {
        int[] array = getRandomArray();
        display(array);

        sort(array);
        display(array);
    }

    public void test(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            nums[i] = nums[minIndex];
        }
    }

}
