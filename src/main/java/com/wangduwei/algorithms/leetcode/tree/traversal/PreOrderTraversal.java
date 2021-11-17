package com.wangduwei.algorithms.leetcode.tree.traversal;

import java.util.Stack;

/**
 * @author : wangduwei
 * @date : 2020/5/14
 * @description :
 */
public class PreOrderTraversal extends TraversalBinaryTree {

    /**
     * 先序遍历---递归
     */
    public static void theFirstTraversal(TraversalBinaryTree.Node root) {
        printNode(root); // root
        if (root.getLeftNode() != null) { // left
            theFirstTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) { // right
            theFirstTraversal(root.getRightNode());
        }
    }

    /**
     * 前序遍历---非递归算法
     */
    public static void theFirstTraversal_Stack(Node root) {
        Stack<Node> stack = new Stack<Node>();//初始化栈
        Node node = root;                    //遍历过程中移动此节点
        while (node != null || stack.size() > 0) { // 将所有左孩子压栈
            if (node != null) { //节点不为空，
                printNode(node);// 输出该节点
                stack.push(node);//节点入栈
                node = node.getLeftNode();//指向左孩子
            } else {        //节点为空
                node = stack.pop();//出栈返回，去遍历右孩子
                node = node.getRightNode();
            }
        }
    }

    public static void theFirstTraversal_Stack2(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getData() + ",");
            if (node.getRightNode() != null){
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode()!=null){
                stack.push(node.getLeftNode());
            }
        }
    }

    public static void main(String[] args) {
        Node root = init();
        System.out.println("先序遍历递归");
        theFirstTraversal(root);

        System.out.println("");
        System.out.println("先序遍历非递归");
        theFirstTraversal_Stack(root);

        System.out.println("");
        System.out.println("先序遍历非递归2");
        theFirstTraversal_Stack2(root);

    }

}
