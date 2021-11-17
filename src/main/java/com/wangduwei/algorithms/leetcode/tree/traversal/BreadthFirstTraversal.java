package com.wangduwei.algorithms.leetcode.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

import static com.wangduwei.algorithms.leetcode.tree.traversal.TraversalBinaryTree.printNode;

/**
 * <p>广度优先搜索
 *
 * @author : wangduwei
 * @since : 2020/7/21  14:12
 **/
public class BreadthFirstTraversal {

    public void breadthFirst2(TraversalBinaryTree.Node node) {
        Queue<TraversalBinaryTree.Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            printNode(node);
            if (node.getLeftNode() != null) {
                queue.offer(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.offer(node.getRightNode());
            }
        }
    }
}
