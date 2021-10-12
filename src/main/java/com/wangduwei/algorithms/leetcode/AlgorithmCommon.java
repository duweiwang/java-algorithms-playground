package com.wangduwei.algorithms.leetcode;


import java.util.List;

/**
 * <p>
 *
 * @author : wangduwei
 * @since : 2020/3/12  9:58
 **/
public class AlgorithmCommon {

    /**
     * 产生测试数据
     *
     * @return
     */
    public static ListNode generateList() {
        ListNode head = new ListNode(1);
        ListNode next = null;
        for (int i = 0; i < 11; i++) {
            if (head.next == null) {
                next = head;
            }
            next.next = new ListNode(i + 2);
            next = next.next;
        }
        return head;
    }

    public static TreeNode generateTreeLevel3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = generateList();
        printListNode(head);
    }

    public static <T> void printDoubleJavaList(List<List<T>> list) {
        for (List<T> t : list) {
            printSingleJavaList(t);
        }
    }

    public static <T> void printSingleJavaList(List<T> list) {
        for (T t : list) {
            System.out.print(t +", ");
        }
    }
}
