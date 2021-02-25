package com.example.mathdemo;

import java.util.List;

/**
 * Created by xty on 21-2-24.
 * <p>
 * 拉不拉 是一个git主
 * 有一些讲解
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-lian-biao-ti-mu-xun-lian-di-gui-si-wei/di-gui-fan-zhuan-lian-biao-de-yi-bu-fen
 */
public class LabuLa {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
        while (head != null || head.next != null) {
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
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 25.K个一组翻转链表（困难）
     */

    //反转以 a 为头结点的链表
    ListNode reverse2(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverseAB(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = b;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    //K个一组翻转链表（困难）
    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        //反转前 k个元素
        ListNode newHead = reverseAB(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 二叉树
     */
    public static int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

    /**
     * 反转二叉树
     *
     * 交换左右节点
     */

    public TreeNode invertTree(TreeNode root) {
        //base case
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

}
