package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * <>非递归算法！！！！加强</>
 *
 * @author : wangduwei
 * @date : 2020/5/28
 * @description :
 */
public class _145_tree_postOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList();

        traversal(root, result);

        return result;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        list.add(root.val);
    }

}
