package com.wangduwei.algorithms.sort.exchange;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

/**
 * 外部指针标识有序和无需区间。
 *
 * 内指针不断交换元素，将一个最大或最小的元素移动到边界
 */
public class BubbleSort extends BaseSortAlgorithms {
    /*
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     */
    public static void sort(int[] numbers) {
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {  //交换两数位置
                    swap(numbers,j,j+1);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//从后往前推小的
            for (int j = arr.length - 1; j > i; j--) {//从最后一个开始遍历
                if (arr[j] < arr[j - 1]) {
                   swap(arr,j,j-1);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = getRandomArray();
        display(array);

//        BubbleSort.bubbleSort(array);
//        sort(array);
        test(array);
        display(array);
    }


//无聊随手敲
    private static void test(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

}
