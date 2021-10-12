package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @author : wangduwei
 * @date : 2020/5/28
 * @description :
 */
public class _107_tree_level_traversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList(), temp;
        queue.add(root);

        while (!queue.isEmpty()) {
            temp = new LinkedList();
            List<Integer> list = new ArrayList();
            for (TreeNode node : queue) {
                list.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            queue = temp;
            result.add(0, list);

        }
        return result;
    }
}
