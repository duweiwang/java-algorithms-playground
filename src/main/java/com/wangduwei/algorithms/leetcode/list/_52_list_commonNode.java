package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * 面试题52. 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/mian-shi-ti-52java-shuang-zhi-zhen-da-bai-100-by-u/
 *
 * @author : wangduwei
 * @date : 2020/6/14
 * @description :
 */
public class _52_list_commonNode {


    /**
     * 两个链表第一个公共结点：
     * 先判断两个链表的长度，做差 = n，让长的先走n步，再一起走
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA), lengthB = getLength(headB);
        ListNode a = headA, b = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++)
                a = a.next;
        } else {
            for (int i = 0; i < lengthB - lengthA; i++)
                b = b.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next, length++) ;
        return length;
    }

}
