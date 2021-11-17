package com.wangduwei.algorithms.leetcode.tree.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : wangduwei
 * @since : 2020/4/9  16:48
 **/
public class TraversalBinaryTree {

    public static void printNode(Node node) {
        System.out.print(node.getData());
    }



    /* 广度优先遍历二叉树*/
    public void breadthFirst(Node node) {
        Deque<Node> nodeDeque = new ArrayDeque();
        nodeDeque.add(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.removeFirst();//取出并移除!!
            printNode(node);
            if (node.getLeftNode() != null) {
                nodeDeque.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                nodeDeque.add(node.getRightNode());
            }
        }
    }

    public static void main(String[] args) {
        TraversalBinaryTree tree = new TraversalBinaryTree();

        Node root = init();

        System.out.println("广度优先");
        tree.breadthFirst(root);
        System.out.println("");

//        System.out.println("广度优先2");
//        tree.breadthFirst2(root);

//        System.out.print("深度优先遍历");
//        tree.depthFirstSearch(root);
    }

    public static Node init() {// 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，
        // 而初始化是按顺序初始化的，不逆序建立会报错
        Node J = new Node("I", 8, null, null);
        Node H = new Node("H", 4, null, null);
        Node G = new Node("G", 2, null, null);
        Node F = new Node("F", 7, null, J);
        Node E = new Node("E", 5, H, null);
        Node D = new Node("D", 1, null, G);
        Node C = new Node("C", 9, F, null);
        Node B = new Node("B", 3, D, E);
        Node A = new Node("A", 6, B, C);
        return A; // 返回根节点
    }

    /**
     * A(6)
     * B(3)					C(9)
     * D(1)			E(5)		F(7)		null
     * null	 G(2)	H(4)   null	 null   J(8)
     * null   null
     */

    public static class Node {
        private int data;
        private String name;
        private Node leftNode;
        private Node rightNode;

        public Node(String name, int data, Node leftNode, Node rightNode) {
            this.name = name;
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }


}
