package com.wangduwei.algorithms.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 在数组中，找到所有的组合使其和为target
 *https://mp.weixin.qq.com/s/O53R9GqwmqBi-2gRoVuvjA
 * @author : wangduwei
 * @since : 2020/7/1  9:52
 **/
public class SumTarget {

    public static void main(String[] args) {
        int[] array = {2,3,4,5,6};
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> cur,
                                  int candidates[], int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //相当于遍历N叉树的子节点
        for (int i = start; i < candidates.length; i++) {
            //如果当前节点大于target我们就不要选了
            if (target < candidates[i])
                continue;
            //由于在java中List是引用传递，所以这里要重新创建一个
            List<Integer> list = new ArrayList<>(cur);
            list.add(candidates[i]);
            backtrack(result, list, candidates, target - candidates[i], i);
        }
    }
}
