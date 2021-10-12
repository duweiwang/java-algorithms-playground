package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * <p>移除倒数第N个节点
 *
 * @author : wangduwei
 * @since : 2020/3/12  18:23
 **/
public class RemoveLastNNode {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        RemoveLastNNode.removeNthFromEnd(node,3);
    }

    /**
     * 添加头结点会简单点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        // 移动N+1保证中间差n个元素
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 移动两个指针，保持他们的间距
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        //交换结点
        second.next = second.next.next;
        return dummy.next;
    }

}
