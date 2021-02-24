package com.example.mathdemo;

/**
 * Created by xty on 21-2-24.
 *
 * 拉不拉 是一个git主
 * 有一些讲解
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-lian-biao-ti-mu-xun-lian-di-gui-si-wei/di-gui-fan-zhuan-lian-biao-de-yi-bu-fen
 */
public class LabuLa {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表逆序 递归
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        while(head != null || head.next !=null) {
            ListNode next = head.next;
            ListNode temp = dummy.next;
            head.next = head.next.next;
            dummy.next = next;
            next.next = temp;
        }
        return dummy.next;
    }

    /**
     * 反转链表前 N 个节点
     *
     * @param head
     * @param n
     * @return
     */

    ListNode reverseN(ListNode head, int n) {
        ListNode temp = null;
        if (n == 1) {
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head, n - 1);
        head.next.next = head;
        head.next = temp;
        return last;

    }

    /**
     * 反转链表的一部分
     */

    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }

    /**
     * 25.K个一组翻转链表（困难）
     */


}
