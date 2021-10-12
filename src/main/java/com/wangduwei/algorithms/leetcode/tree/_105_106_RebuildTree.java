package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.HashMap;

/**
 * <p>前序遍历 和 中序遍历=>二叉树
 *
 * @author : wangduwei
 * @since : 2020/6/15  10:21
 **/
public class _105_106_RebuildTree {
    //在中序序列中查找与前序序列首结点相同元素的时候，如果使用 while 循环去一个个找效率很慢
    //这里我们借助数据结构 HashMap 来辅助查找，在开始递归之前把所有的中序序列的元素和
    // 它们所在的下标存到一个 map 中，这样查找的时间复杂度是 O(logn)
    HashMap<Integer, Integer> map = new HashMap<>();

    //保留的前序遍历
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //在开始递归之前把所有的中序序列的元素和它们所在的下标存到一个 map 中
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        //二叉树的重要性质是递归
        return recursive(0, 0, inorder.length - 1);
    }

    /**
     * 根据前序遍历序列和中序遍历序列重新组建二叉树
     */
    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {

        //子树中序遍历为空，说明已经越过叶子节点，此时返回 nul
        if (in_left_idx > in_right_idx) {
            return null;
        }

        //root_idx是在前序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);

        // 通过 map ，根据前序的根节点的值，在中序中获取当前根的索引
        int idx = map.get(preorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是 +1 ,左边边界就是 left ，右边边界是中间区分的idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        root.right = recursive(pre_root_idx + (idx - 1 - in_left_idx + 1) + 1, idx + 1, in_right_idx);

        return root;
    }

    /** 106. 从中序与后序遍历序列构造二叉树 */
    static class PostIn2Tree {
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int len = inorder.length;

            for (int i = 0; i < len; i++) {
                map.put(inorder[i], i);
            }

            return buildTree(postorder, 0, len - 1, 0, len - 1);
        }

        public TreeNode buildTree(int[] postorder, int inL, int inR, int poL, int poR) {
            if (inL > inR || poL > poR) return null;

            TreeNode node = new TreeNode(postorder[poR]);//后序遍历最后一个是根节点
            int head = map.get(postorder[poR]);//根节点在中序遍历的位置

            node.right = buildTree(postorder, head + 1, inR, poL + (head - inL), poR - 1);
            node.left = buildTree(postorder, inL, head - 1, poL, poL + (head - inL) - 1);

            return node;
        }
    }


    /** 105、前序中序构建二叉树 */
    static class PreIn2Tree {
        //-----------------105-----前序遍历+中序遍历

        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = inorder.length;

            for (int i = 0; i < len; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR) {
            if (preL > preR || inL > inR) {
                return null;
            }

            TreeNode node = new TreeNode(preorder[preL]);
            int head = map.get(preorder[preL]);

            node.left = buildTree(preorder, inorder, preL + 1, preL + (head - inL), inL, head - 1);
            node.right = buildTree(preorder, inorder, preL + (head - inL) + 1, preR, head + 1, inR);

            return node;
        }

//    作者：CharlesGao
//    链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/javaluo-ji-qing-xi-miao-jie-105106liang-dao-bian-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
