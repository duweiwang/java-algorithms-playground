package com.wangduwei.algorithms.leetcode.tree;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输出第K层的元素
 *
 * @author : wangduwei
 * @date : 2020/4/5
 * @description :
 */
public class printLevelK {
    public static void main(String[] args) {
        TreeNode root = AlgorithmCommon.generateTreeLevel3();
        printKDistant(root, 3);
    }

    static void printKDistant(TreeNode root, int klevel) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);//层分隔符
        int level = 1;

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (level == klevel && temp != null) {
                System.out.print(temp.val + " ");
            }
            if (temp == null) {
                if (q.peek() != null)
                    q.add(null);
                level++;

                if (level > klevel)
                    break;
            } else {
                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }

}
