package com.wangduwei.algorithms.leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : wangduwei
 * @date : 2020/5/14
 * @description :
 */
public class InOrderTraversal extends TraversalBinaryTree {

    /**
     * 中序遍历---递归
     */
    public static void theInOrderTraversal(TraversalBinaryTree.Node root) {
        if (root.getLeftNode() != null) { // 左
            theInOrderTraversal(root.getLeftNode());
        }
        printNode(root); // 中
        if (root.getRightNode() != null) {
            theInOrderTraversal(root.getRightNode());// 右
        }
    }

    /**
     * 中序遍历---非递归算法
     */
    public static void theInOrderTraversal_Stack(Node root) {
        Stack<Node> stack = new Stack<Node>();//初始化栈
        Node node = root;                        //临时指针节点
        while (node != null || stack.size() > 0) {//栈不空或者节点不空
            if (node != null) {                    //节点不空的情况
                stack.push(node);
                node = node.getLeftNode();
            } else {                        //栈不空的情况
                node = stack.pop();
                printNode(node);
                node = node.getRightNode();
            }
        }
    }

    /**
     * 注意peek的使用-leetcode验证通过
     */
    List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.empty()) {
            Node tmp = stack.peek();
            if (tmp != null) {
                stack.pop();
                if (tmp.getRightNode() != null)
                    stack.push(tmp.getRightNode());
                stack.push(tmp);
                stack.push(null);
                if (tmp.getLeftNode() != null)
                    stack.push(tmp.getLeftNode());
            } else {
                stack.pop();
                result.add(stack.peek().getData());
                stack.pop();
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Node root = init();

        System.out.println("中序遍历递归");
        theInOrderTraversal(root);
        System.out.println("");

        System.out.println("中序遍历非递归");
        theInOrderTraversal_Stack(root);
        System.out.println("");
    }

}
