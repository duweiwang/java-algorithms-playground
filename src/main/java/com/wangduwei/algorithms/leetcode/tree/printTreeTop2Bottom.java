package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Queued 接口和Dequeue接口的方法没掌握
 * 从上到下输出二叉树
 *
 * @author : wangduwei
 * @date : 2020/4/1
 * @description :
 */
public class printTreeTop2Bottom {
    public static void main(String[] args) {
        TreeNode root = AlgorithmCommon.generateTreeLevel3();
        int[] result = printTreeTop2Bottom(root);
        AlgorithmCommon.printArray(result);
    }

    public static int[] printTreeTop2Bottom(TreeNode node) {
        if (node == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            node = queue.poll();

            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
