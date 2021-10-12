package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>翻转二叉树
 *
 * @author : wangduwei
 * @since : 2020/6/16  17:23
 **/
public class _226_reverseTree {

    /*递归法*/
    public TreeNode invertTreeRecur(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeRecur(root.right);
        TreeNode left = invertTreeRecur(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /*迭代法*/
    public TreeNode invertTreeIterator(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            swap(current);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    private void swap(TreeNode current){
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }

}
