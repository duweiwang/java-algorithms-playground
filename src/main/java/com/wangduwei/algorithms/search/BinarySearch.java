package com.wangduwei.algorithms.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch.binarySearch(array, 7);
    }

    public static int binarySearch(int[] array, int searchKey) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) >>> 1;
            System.out.print("middle = " + middle);
            if (searchKey == array[middle]) {
                return middle;
            } else if (searchKey < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
