package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * <p>找到链表的中间值（中间节点）
 *
 * @author : wangduwei
 * @since : 2020/3/18  15:13
 **/
public class FindListMiddle {

    public static void main(String[] args) {
        ListNode testList = AlgorithmCommon.generateList();

        AlgorithmCommon.printListNode(testList);

        int result = FindListMiddle.findMiddle(testList);
        System.out.println(result);
    }



    public static int findMiddle(ListNode head) {

        ListNode fast = head, slow = head;

        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

}
