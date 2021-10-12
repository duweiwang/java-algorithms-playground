package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * 链表每K个结点逆序（分组逆序）
 *
 * @author : wangduwei
 * @date : 2020/5/30
 * @description :
 */
public class ReverseKList {

    public static void main(String[] args) {
        ListNode list = AlgorithmCommon.generateList();
        AlgorithmCommon.printListNode(list);

        ListNode result = ReverseKList.reverseKGroup(list,3);
        AlgorithmCommon.printListNode(result);
    }

    /**
     * 递归
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if (temp == null)
            return head;

        ListNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        ListNode newHead = reverseList(head);
        //把之后的节点进行分组逆序
        ListNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;

        return newHead;
    }

    //逆序单链表
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
