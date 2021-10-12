package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

/**
 * <p>最近公共祖先
 *
 * @author : wangduwei
 * @since : 2020/5/28  14:17
 **/
public class NearCommonNode {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
        if (root == null || root == p || root == q)
            return root;

        //去该节点的左子树上找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //去该节点的右子树上找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            //左子树上没有，说明在右子树上
            return right;
        } else if (right == null) {
            //右子树上没有，说明在左子树上
            return left;
        }
        //左右均有，说明该节点即为最近公共祖先
        return root;
    }
}
