package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * <p>反转链表
 *
 * @author : wangduwei
 * @since : 2020/3/11  17:53
 **/
public class _206_list_reverse_list {

    public static void main(String[] args) {
        ListNode head = AlgorithmCommon.generateList();
        AlgorithmCommon.printListNode(head);
        System.out.println();
//        reverse(head);
        ListNode reversed = reverseIteratively(head);
        AlgorithmCommon.printListNode(reversed);
        System.out.println();

        ListNode reversedRecursion = reverseRecursion(reversed);
        AlgorithmCommon.printListNode(reversedRecursion);
    }

    /*自己实现*/
//    public static ListNode reverse(ListNode head) {
//        ListNode prev = null, current = head;
//
//        while (current != null) {
//            ListNode temp = current.next;
//            current.next = prev;
//            prev = current;
//            current = temp;
//        }
//        return prev;
//    }

    /**
     * 这里使用了三个指针做交换---------迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverseIteratively(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;

            //改变指针方向，对第一个节点来说，他的前一个节点是null
            head.next = pre;
            //向前移动两个指针
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归实现
     *
     * @return
     */
    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode new_head = reverseRecursion(next);
        next.next = head;
        head.next = null;
        return new_head;
    }

}
