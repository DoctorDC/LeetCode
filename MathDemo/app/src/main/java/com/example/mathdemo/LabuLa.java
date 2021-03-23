package com.example.mathdemo;

import java.util.Arrays;
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
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = temp;
        return last;

    }

    /**
     * 反转链表的一部分
     */

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
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

    /**
     * 1.反转ab之间 可以先b当成null，相当于反转a为head的链表
     */
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
        // 递归反转后续链表并连接起来
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
     * <p>
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


    /*
    已知有125  组成11最小个数
        找到10 9 6最小组成
        然后再加1

     */
    //暴力
    public int coinChangebaoli(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChangebaoli(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    //
    /**
     * 使用备忘录
     * <p>
     * 先创建一个备忘数组mem
     * 进入for之前检查数组mem[amount]的值
     * if有值 返回 ，没有值 进入for
     * 最后把res值给mem[amount]
     */

    int[] mem;

    public int coinChange(int[] coins, int amount) {
        mem = new int[amount + 1];
        Arrays.fill(mem, -666);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        if (mem[amount] != -666)
            return mem[amount];
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        mem[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return mem[amount];
    }

    //自低向上
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }

        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];

    }

}
