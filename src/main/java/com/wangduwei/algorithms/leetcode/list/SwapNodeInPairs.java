package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * <p>两两交换链表节点
 *
 * @author : wangduwei
 * @since : 2020/3/17  16:35
 **/
public class SwapNodeInPairs {

    public static void main(String[] args) {
        ListNode head = AlgorithmCommon.generateList();
        AlgorithmCommon.printListNode(head);
        ListNode solution = SwapNodeInPairs.solution(head);
        AlgorithmCommon.printListNode(solution);
    }

    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head.next;

        ListNode prev = head, next = head.next, temp,last = null;

        while (prev != null && next != null) {
            temp = next.next;

            prev.next = temp;
            next.next = prev;

            if (last == null){
                last = prev;
            }

            //next two
            prev = prev.next;
            next = prev.next;

            last.next =next;
            last = prev;
        }

        return dummy.next;
    }

}
