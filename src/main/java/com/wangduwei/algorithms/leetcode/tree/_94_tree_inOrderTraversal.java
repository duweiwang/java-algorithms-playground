package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历--
 * 非递归算法怎么写！！！
 *
 * @author : wangduwei
 * @date : 2020/5/28
 * @description :
 */
public class _94_tree_inOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        if (root.left != null) {
            preOrderTraversal(root.left, result);
        }
        if (root.right != null) {
            preOrderTraversal(root.right, result);
        }
    }
}
