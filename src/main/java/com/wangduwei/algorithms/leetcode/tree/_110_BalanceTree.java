package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

/**
 * 二叉树是否平衡：高度相差小于2
 * {@linkplain https://leetcode-cn.com/problems/balanced-binary-tree/}
 *
 * @author : wangduwei
 * @date : 2020/5/2
 * @description :
 */
public class _110_BalanceTree {

    /*public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }

    static int treeDepth(TreeNode root) {
        if (root != null) {
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }*/

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        } else {
            return isBalance(root.left) & isBalance(root.right);
        }

    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

}
