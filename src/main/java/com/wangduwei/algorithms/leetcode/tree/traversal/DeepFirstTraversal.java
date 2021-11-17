package com.wangduwei.algorithms.leetcode.tree.traversal;

import java.util.Stack;

import static com.wangduwei.algorithms.leetcode.tree.traversal.TraversalBinaryTree.printNode;

/**
 * <p>深度优先
 *
 * @author : wangduwei
 * @since : 2020/7/21  14:10
 **/
public class DeepFirstTraversal {

    /* 深度优先遍历二叉树*/
    public void depthFirstSearch(TraversalBinaryTree.Node root) {
        Stack<TraversalBinaryTree.Node> stack = new Stack<TraversalBinaryTree.Node>();
        stack.push(root);
        TraversalBinaryTree.Node node;
        while (!stack.empty()) {
            node = stack.pop();
            printNode(node);  //遍历根结点
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());  //先将右子树压栈
            }
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());  //再将左子树压栈
            }
        }
    }
}
