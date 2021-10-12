package com.wangduwei.algorithms.sort;

import java.util.Random;

public class BaseSortAlgorithms {

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static int[] getRandomArray() {
        int[] array = new int[50];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = new Random().nextInt(50);
        }
        return array;
    }

}
