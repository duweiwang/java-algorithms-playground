package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * 两个链表相加
 */
public class AddTwoNum_ {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1).next = new ListNode(2).next = new ListNode(3);
        ListNode node2 = new ListNode(4).next = new ListNode(5).next = new ListNode(6);
        ListNode result = AddTwoNum_.addTwoNumbers(node1, node2);
        AlgorithmCommon.printListNode(result);
    }

    /**
     * 这里没有复用结点
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode head = null;
        boolean carry = false;
        while (l1 != null || l2 != null) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = carry ? (val1 + val2) % 10 + 1 : (val1 + val2) % 10;

            if (current == null) {
                current = new ListNode(sum);
                head = current;
            } else {
                ListNode newList = new ListNode(sum);
                current.next = newList;
                current = newList;
            }
            sum = carry ? val1 + val2 + 1 : val1 + val2;
            if (sum > 9) {
                carry = true;
            } else {
                carry = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }

    /**
     * 两个链表相加
     * 复用一个链表的结点
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean carry = false;//进位
        ListNode l1Prev = null, l2Prev = null, result = l1;

        //两个链表都有值，相加直到一个链表末尾
        while (l1 != null && l2 != null) {
            int add = l1.val + l2.val + (carry ? 1 : 0);

            l1.val = add % 10 ;
            carry = add > 9;

            l1Prev = l1;
            l2Prev = l2;
            l1 = l1.next;
            l2 = l2.next;
        }

        //有一个链表已经走到头，
        if (l1 == null && l2 != null) {
            addSingleList(l1Prev, l2, carry);
        }

        if (l1 != null && l2 == null) {
            addSingleList(l2Prev, l1, carry);
        }
        if (l1 == null && l2 == null && carry){
            l1Prev.next = new ListNode(1);
        }
        return result;
    }

    //单链表和进位相加
    private static void addSingleList(ListNode l1, ListNode l2, boolean carry) {
        l1.next = l2;
        while (l2 != null) {
            int add = l2.val + (carry ? 1 : 0);
            l2.val = add % 10;
            carry = add > 9;
            l1 = l2;
            l2 = l2.next;
        }
        if (carry) {
            l1.next = new ListNode(1);
        }
    }

}
