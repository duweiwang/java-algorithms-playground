package com.wangduwei.algorithms.leetcode.tree;


import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.Arrays;

/**
 * 有序数组转最小高度二叉树
 * give a ordering array,build a min height binary tree
 */
public class SortedArrayToBST {

    /**
     * Leetcode solution
     */
    public TreeNode sortedArrayToBSTLeetCode(int[] nums) {
        if(nums.length==0) return null;
        TreeNode n = new TreeNode(nums[nums.length/2]);
        n.left = sortedArrayToBSTLeetCode(Arrays.copyOfRange(nums,0,nums.length/2));
        n.right = sortedArrayToBSTLeetCode(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
        return n;
    }



    public static void main(String[] args) {
        int[] num = {-10, -3, 0, 5, 9};
        SortedArrayToBST.sortedArrayToBST(num);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * wrong solution
     */
    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start >= end) return null;
        TreeNode treeNode = new TreeNode(nums[(end - start) / 2]);
        treeNode.left = sortedArrayToBST(nums, 0, (end - start) / 2);
        treeNode.right = sortedArrayToBST(nums, (end - start) / 2 + 1, end);
        return treeNode;
    }
}
