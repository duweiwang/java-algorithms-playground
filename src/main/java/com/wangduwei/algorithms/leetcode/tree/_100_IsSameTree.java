package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

/**
 * <p> 两棵树是否相同
 *
 * @author : wangduwei
 * @since : 2020/4/16  10:07
 **/
public class _100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p == null && q == null)
            return true;
        else {
            boolean same = isSameTree(p.left, q.left);
            if (!same || p.val != q.val) {
                return false;
            }
            return isSameTree(p.right, q.right);
        }
    }

    /*自己写的，leetcode通过*/
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) return false;
        if (p == null && q == null) return true;

        if (p.val != q.val) return false;
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}
