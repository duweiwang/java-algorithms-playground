package com.wangduwei.algorithms.dp.min_coin_count;

import java.util.Arrays;

/**
 * 使用备忘录存储中间结果，进行优化
 */
public class StepFour {

    int getMinCountsHelper(int total, int[] values, int[] memo) {
        int savedMinCount = memo[total];
        if (savedMinCount != -2) {
            return savedMinCount;
        }


        int valueLength = values.length;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < valueLength; i++) { // 遍历所有面值
            int currentValue = values[i];
            // 如果当前面值大于硬币总额，那么跳过
            if (currentValue > total) {
                continue;
            }

            // 使用当前面值，得到剩余硬币总额
            int rest = total - currentValue;
            int restCount = getMinCountsHelper(rest, values, memo);
            // 如果返回-1，说明组合不可信，跳过
            if (restCount == -1) {
                continue;
            }

            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }

        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            memo[total] = -1;
            return -1;
        }

        memo[total] = minCount; // 记录到备忘录
        return minCount; // 返回最小硬币数量
    }

    int getMinCountsSol() { // 入口函数
        int[] values = {3, 5}; // 硬币面值
        int total = 14; // 总值

        int[] memo = new int[total + 1];// , -2); // 备忘录，没有缓存的元素为-2
        Arrays.fill(memo, -2);
        memo[0] = 0; // 其中0对应的结果也是0，首先存在备忘录中

        // 求得最小的硬币数量，并输出结果
        return getMinCountsHelper(total, values, memo); // 输出结果
    }


}
