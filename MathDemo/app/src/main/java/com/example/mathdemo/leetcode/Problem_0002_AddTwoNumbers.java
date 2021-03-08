package com.example.mathdemo.leetcode;

import java.util.List;

public class Problem_0002_AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.val = value;
        }
    }

    public static ListNode addTwoNum(ListNode l1, ListNode l2) {
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode node = null;
        ListNode pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 != null ? c1.val : 0;
            n2 = c2 != null ? c2.val : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca == 1) {
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return reverseList(node);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode addTwoNum2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        int next = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        while (l1 != null) {
            sum = l1.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            sum = l2.val + next;
            cur.next = new ListNode(sum % 10);
            next = sum / 10;
            l2 = l2.next;
            cur = cur.next;
        }
        if (next != 0) {
            cur.next = new ListNode(next);
        }
        return result.next;
    }


}
