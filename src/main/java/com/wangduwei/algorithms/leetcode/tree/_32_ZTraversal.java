package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Z型打印树
 *
 * @author : wangduwei
 * @since : 2020/4/16  11:48
 **/
public class _32_ZTraversal {

    public static void main(String[] args) {
        TreeNode root = AlgorithmCommon.generateTreeLevel3();
        List<List<Integer>> result = _32_ZTraversal.zigzagLevelOrder(root);
        AlgorithmCommon.printDoubleJavaList(result);
    }

    //方法一：层序遍历 + 双端队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    //方法三：层序遍历 + 倒序
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (res.size() % 2 == 1)
                Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0, result);
        return result;
    }

    @SuppressWarnings("unchecked")
    private static void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root != null) {
            LinkedList<Integer> subList;
            if (level >= result.size()) {
                subList = new LinkedList<>();
                result.add(subList);
            } else {
                subList = (LinkedList) result.get(level);
            }
            if (level % 2 == 0) {
                subList.addFirst(root.val);
            } else { // add to right
                subList.add(root.val);
            } // add to left
            dfs(root.right, level + 1, result);
            dfs(root.left, level + 1, result);
        }
    }
}
