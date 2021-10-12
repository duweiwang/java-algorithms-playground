package com.wangduwei.algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后续遍历，使用递归和非递归实现
 *
 * @author : wangduwei
 * @date : 2020/7/4
 * @description :
 */
public class _590_NTree_postOrderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        traverse(root,result);
        return result;
    }

    public void traverse(Node node,List<Integer> list){
        if(node != null){
            if(node.children != null){
                for(Node n:node.children){
                    traverse(n,list);
                }
            }
            list.add(node.val);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
