package com.wangduwei.algorithms.leetcode.list;

import com.wangduwei.algorithms.leetcode.ListNode;

/**
 * <p>
 * 假设起点到环的起点距离为m，已经确定有环，环的周长为n，
 * （第一次）相遇点距离环的起点的距离是k。那么当两者相遇时，慢指针移动的总距离为i，i = m + a * n + k，
 * 因为快指针移动速度为慢指针的两倍，那么快指针的移动距离为2i，2i = m + b * n + k。
 *
 * 其中，a和b分别为慢指针和快指针在第一次相遇时转过的圈数。我们让两者相减（快减慢），
 * 那么有i = (b - a) * n。即i是圈长度的倍数。利用这个结论我们就可以理解Floyd解法为什么能确定环的起点。
 *
 * 将一个指针移到链表起点，另一个指针不变，即距离链表起点为i处，两者同时移动，每次移动一步。
 * 当第一个指针前进了m，即到达环起点时，另一个指针距离链表起点为i + m。考虑到i为圈长度的倍数，
 * 可以理解为指针从链表起点出发，走到环起点，然后绕环转了几圈，所以第二个指针也必然在环的起点。
 * 即两者相遇点就是环的起点。
 *
 * @author : wangduwei
 * @since : 2020/5/13  14:02
 **/
public class _142_list_detect_circle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
