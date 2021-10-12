package com.wangduwei.algorithms.sort.exchange;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;


/**
 * https://juejin.im/post/5b55660ee51d4519202e2003
 */
public class QuickSort extends BaseSortAlgorithms {
    /**
     * 快排一次划分
     */
    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }

    private static void sort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = partition(arr, left, right);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
    }


    public static void main(String[] args) {
        int[] array = getRandomArray();
        display(array);

        sort(array, 0, array.length - 1);
        display(array);
    }


    /**
     * 无聊写的一次划分，有问题，请对比！！！！！！！！！
     */
    public int test(int[] array,int left,int right){
        int hole = array[left];

        while(left < right){
            while(left < right && array[right] > hole){
                right--;
            }
            if (array[right] < hole){
                array[left] = array[right];
            }
            while(left < right && array[left] < hole){
                left++;
            }

            if (array[left] > hole){
                array[right] = array[left];
            }
        }
        array[left] = hole;
        return left;
    }


}
