package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p> 求树的深度
 *
 * @author : wangduwei
 * @since : 2020/4/27  9:33
 **/
public class DeepOfTree {
    public static int deepOfTree(TreeNode node) {
        if (node == null) return 0;

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            if (n == null) {
                level++;
                if (queue.peek() != null) {
                    queue.add(null);
                }
            } else {
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);

            }
        }
        return level;
    }

    //递归
    public static int treeDepth(TreeNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

    /*from leetcode*/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> queue = new LinkedList(), tmp;
        queue.add(root);

        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    /*from leetcode*/
    /*public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);

        int deep = DeepOfTree.deepOfTree(root);
        System.out.print(deep);
        System.out.println();
        System.out.print(treeDepth(root));
    }
}
