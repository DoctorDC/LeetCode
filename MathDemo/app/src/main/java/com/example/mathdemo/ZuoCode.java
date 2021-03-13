package com.example.mathdemo;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by xty on 21-3-3.
 */
public class ZuoCode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 归并排序
     *
     * @param arr 要排序的数组
     * @param L   左边界
     * @param R   右边界
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];

        }

    }


    public static void process2(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process2(arr, L, mid);
        process2(arr, mid + 1, R);
        merge2(arr, L, mid, R);
    }

    public static void merge2(int[] arr, int L, int M, int R) {
        int p1 = L;
        int p2 = M + 1; //将数组分成两部分 L~M  M+1~R
        int help[] = new int[R - L + 1];//数组
        int i = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }

        //数组两个部分长度不相等情况，需要对没有遍历的部分继续遍历
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
//            Log.d("1234", "i==" + i + ",L==" + L + ",help==" + help[i]);
//            Log.d("1234", "########");
            arr[L + i] = help[i];
        }

    }

    /**
     * 两个链表相交问题
     * <p>
     * 1.先让两个链表遍历，
     * 2.长链表，走到和短链表一样
     * 3.遍历比较
     *
     * 快指针和慢指针相遇后，
     * 快指针回到头部
     * 再次相遇就是入环节点
     */
    //找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null)
                return null;
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果两个链表都无环，返回第一个相交节点，如果不相交，返回null
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2)
            return null;
        //n =链表1 -
        // 链表2
        cur1 = n > 0 ? head1 : head2;//cur1 长链表
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)
            return noLoop(head1, head2);
        if (loop1 != null && loop2 != null)
            return bothLoop(head1, loop1, head2, loop2);
        return null;
    }

    /**
     * 链表逆序
     */


    /**
     * 盛水问题
     */

    public static int water(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        int N = arr.length;
        int L = 1;
        int R = N - 2;
        int leftMax = arr[0];
        int rightMax = arr[N - 1];
        int res = 0;
        while (L <= R) {
            if (leftMax <= rightMax) {
                res += Math.max(0, leftMax - arr[L]);
                leftMax = Math.max(leftMax, arr[L++]);
            } else {
                res += Math.max(0, rightMax - arr[R]);
                rightMax = Math.max(rightMax, arr[R--]);
            }
        }
        return res;
    }


}
