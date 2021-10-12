package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>是否镜像
 *
 * @author : wangduwei
 * @since : 2020/4/15  16:26
 **/
public class _101_MirrorTree {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            q.add(t1.left);
            q.add(t2.right);

            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    //-------------递归---------------2
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        return dfs(left.left, right.right) && left.val == right.val && dfs(left.right, right.left);
    }
}
