package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.AlgorithmCommon;
import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * 二进制链表转整数
 *
 * @author : wangduwei
 * @date : 2020/5/7
 * @description :
 */
public class BinaryList2Int {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(0);

        AlgorithmCommon.printListNode(node);
        int result = getDecimalValue(node);
        System.out.print(result);
    }

    public static int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

}
