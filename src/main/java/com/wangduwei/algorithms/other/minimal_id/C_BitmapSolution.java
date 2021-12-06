package com.wangduwei.algorithms.other.minimal_id;

/**
 * 利用辅助数组求解O(n)
 */
public class C_BitmapSolution {
    public static int find3(int[] arr) {
        int n = arr.length;  //定义数组长度
        int[] helper = new int[n + 1];  //定义辅助空间
        for (int i = 0; i < n; i++) {  //构造辅助数组
            helper[arr[i]] = 1;
        }
        for (int i = 1; i <= n; i++) {  //扫描辅助数组
            if (helper[i] == 0) {   //如果辅助空间数组下标出现次数为0
                return i;  //返回该元素
            }
        }
        return n + 1;  //若数组长度范围内度存在，则返回n+1
    }
}
