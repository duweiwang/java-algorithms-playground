package com.wangduwei.algorithms.dp.min_coin_count;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 使用递归求解问题：
 * 1、求解所有满足条件的组合；
 * 2、从组合中选出总和最小的组合。如果找不到满足条件的组合那么就返回-1
 *
 */
public class StepThree {


    void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts, ArrayList<ArrayList<Integer>> combinations) {
        if (0 == total) { // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
            combinations.add(new ArrayList<Integer>(currentCounts));
            return;
        }

        int valueLength = values.length;
        for (int i = 0;  i < valueLength; i ++) { // 遍历所有面值
            int currentValue = values[i];
            if (currentValue > total) { // 如果面值大于当前总额，直接跳过
                continue;
            }

            // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList<Integer>(currentCounts);
            newCounts.set(i, newCounts.get(i)+1);
            int rest = total - currentValue;

            getMinCountsHelper(rest, values, newCounts, combinations); // 求解剩余额度所需硬币数量
        }
    }

    int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {
        // 如果没有可用组合，返回-1
        if (0 == combinations.size()) { return -1; }

        int minCount = Integer.MAX_VALUE;
        for (ArrayList<Integer> counts : combinations) {
            int total = 0; // 求当前组合的硬币总数
            for (int count : counts) { total += count; }

            // 保留最小的
            if (total < minCount) { minCount = total; }
        }

        return minCount;
    }

    int getMinCountOfCoins() {
        int[] values = { 5, 3 }; // 硬币面值的数组
        int total = 11; // 总值

        ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(values.length, 0)); // 初始值(0,0)

        ArrayList<ArrayList<Integer>> coinCombinations = new ArrayList<>(); // 存储所有组合
        getMinCountsHelper(total, values, initialCounts, coinCombinations); // 求解所有组合（不去重）

        return getMinimumHelper(coinCombinations); // 输出答案
    }


}
