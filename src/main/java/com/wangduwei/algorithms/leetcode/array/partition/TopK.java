package com.wangduwei.algorithms.leetcode.array.partition;

import com.wangduwei.algorithms.sort.BaseSortAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>最大或最小的K个数 1、使用堆 2、快排思想
 * <p>
 * https://mp.weixin.qq.com/s/aEv5yVvweyHUB2c4Tjiwag
 * //Leet-code三种解法
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author : wangduwei
 * @since : 2020/4/16  12:45
 **/
public class TopK extends BaseSortAlgorithms {

    /*找最小的两个数*/
    public static void main(String[] args) {
        int[] array = {1, 6, 3, 5, 9, 0, 8, 2, 7, 4};
        int[] result = TopK.getTopKHeapImpl(array, 4);
        display(result);
    }

    /*堆实现*/
    public static int[] getTopKHeapImpl(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());

//        Collections.reverseOrder();

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }


    /*快排实现*/
    public int[] getTopKQuickSortImpl(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m - 1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m + 1, hi, k);
        }
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
// 代码参考 Sedgewick 的《算法4》
    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        int v = a[lo];

        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }
}
