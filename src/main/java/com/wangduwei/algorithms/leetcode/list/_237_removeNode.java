package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * 删除链表的结点，只给定要删除的结点
 *
 * @author : wangduwei
 * @date : 2020/7/4
 * @description :
 */
public class _237_removeNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
