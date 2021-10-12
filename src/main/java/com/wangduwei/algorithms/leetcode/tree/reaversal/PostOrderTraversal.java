package com.wangduwei.algorithms.leetcode.tree.reaversal;

import java.util.Stack;

/**
 * @author : wangduwei
 * @date : 2020/5/14
 * @description :
 */
public class PostOrderTraversal extends TraversalBinaryTree{

    /**
     * 后序遍历---递归
     */
    public static void thePostOrderTraversal(Node root) {
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        printNode(root);
    }


    /**
     * 后序遍历---非递归算法
     */
    public static void thePostOrderTraversal_Stack(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();// 构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();

            }
        }
        while (output.size() > 0) {
            printNode(output.pop());
        }
    }

    /**
     * 前序遍历反过来
     * @param root
     */
    private static void thePostOrderTraversal_Stack2(Node root) {
        Stack<Node> src = new Stack<Node>();
        Stack<Node> res = new Stack<Node>();
        src.push(root);

        while (!src.isEmpty()) {
            Node p = src.pop();
            res.push(p);
            if (p.getLeftNode() != null) {
                src.push(p.getLeftNode());
            }
            if (p.getRightNode() != null) {
                src.push(p.getRightNode());
            }
        }
        //输出最终后序遍历的结果
        while(!res.isEmpty()){
            printNode(res.pop());
        }
    }


    public static void main(String[] args) {
        Node root = init();

        System.out.println("后序遍历递归");
        thePostOrderTraversal(root);
        System.out.println("");

        System.out.println("后序遍历非递归");
        thePostOrderTraversal_Stack(root);
        System.out.println("");

        System.out.println("后序遍历非递归");
        thePostOrderTraversal_Stack2(root);
        System.out.println("");
    }
}
