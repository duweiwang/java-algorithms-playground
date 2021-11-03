package com.wangduwei.algorithms.dp.min_coin_count;

public class StepThree_Optimiz {

    int getMinCountsHelper(int total, int[] values) {
        // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
        if (0 == total) { return 0; }

        int valueLength = values.length;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0;  i < valueLength; i ++) { // 遍历所有面值
            int currentValue = values[i];

            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) { continue; }

            int rest = total - currentValue; // 使用当前面值，得到剩余硬币总额
            int restCount = getMinCountsHelper(rest, values);

            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) { continue; }

            int totalCount = 1 + restCount; // 保留最小总额
            if (totalCount < minCount) { minCount = totalCount; }
        }

        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) { return -1; }

        return minCount; // 返回最小硬币数量
    }

    int getMinCountOfCoinsAdvance() {
        int[] values = { 3, 5 }; // 硬币面值的数组
        int total = 11; // 总值

        return getMinCountsHelper(total, values); // 输出答案
    }
}
