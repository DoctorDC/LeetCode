package com.example.mathdemo;

import java.util.HashMap;

/**
 * Created by xty on 21-2-22.
 * 有道上面记录的高频算法题
 */
public class HighFreeCode {
    /**
     * 1 无重复字符的最长子串
     * abccd 使用hashmap
     * 遍历字符串，
     * 将字符串存入map中
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;//长度
        //两个指针
        int i = 0; //头部
        int j = 0; //尾部
        for (; j < n; j++) {
            char a = s.charAt(j);
            if (map.containsKey(a)) {//如果map中包含a，那么移动i到j, j的位置从map中取出
                i = Math.max(map.get(a), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    /**
     * 10 两数相加
     * <p>
     * % 个位 / 进位
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //迭代法
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int total = 0;//相加的和
        int next = 0;//是否进位
        ListNode result = new ListNode();//结果
        ListNode cur = result;

        while (l1 != null && l2 != null) { //l1 或 l2有一个到头
            total = l1.val + l2.val + next;
            cur.next = new ListNode(total % 10);//个位数
            next = total / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        //然后分别遍历l1 l2
        while (l1 != null) {
            total = l1.val + next;
            cur.next = new ListNode(total % 10);
            next = total / 10;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            total = l2.val + next;
            cur.next = new ListNode(total % 10);
            next = total / 10;
            l2 = l2.next;
            cur = cur.next;

        }
        if (next != 0) {
            cur.next = new ListNode(next);
        }
        return result.next;
    }

}
