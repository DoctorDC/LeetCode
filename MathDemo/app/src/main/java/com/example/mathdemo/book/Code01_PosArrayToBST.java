package com.example.mathdemo.book;

public class Code01_PosArrayToBST {

    /**
     * 给一个后续遍历的数组，搜索二叉树
     *
     * 已知一个搜索二叉树后序遍历的数组posarr
     * 根据posarr 重建整棵树
     */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    //2436875
    public static Node posArrayToBST(int[] posArr) {
        // 0~N-1
        return process1(posArr, 0, posArr.length - 1);
    }

    public static Node process1(int[] posArr, int L, int R) {
        if (L > R) return null;
        // L <= R
        // [L ... R]
        Node head = new Node(posArr[R]);
        if (L == R)
            return head;
        // L < R-1
        int M = L - 1;
        for (int i = L; i < R; i++) {
            if (posArr[i] < posArr[R]) {
                M = i;
            }
        }
        // [L .. M] < head   [M+1...R-1] > head
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }


    //采用二分法
    public static Node process3(int[] posArr, int L, int R) {
        if (L > R) return null;
        Node head = new Node(posArr[R]);
        if (L == R)
            return head;
        int M = L - 1;
        int left = L;
        int right = R - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R]) {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        head.left = process1(posArr, L, M);
        head.right = process1(posArr, M + 1, R - 1);
        return head;
    }

    public static Node test(int[] posArr, int L, int R) {
        if (L > R) return null;
        Node head = new Node(posArr[R]);
        if (L == R) return head;
        int left = L;
        int right = R - 1;
        int M = L - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[R]) {
                M = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        head.left = test(posArr, L, M);
        head.right = test(posArr, M + 1, R - 1);
        return head;
    }

}
