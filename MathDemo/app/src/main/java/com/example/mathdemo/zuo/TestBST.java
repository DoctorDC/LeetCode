package com.example.mathdemo.zuo;

import com.example.mathdemo.BriTree;

public class TestBST {
    /**
     * 搜索二叉树套路
     * 左 搜索二叉树 ？
     * 右 搜索二叉树 ?
     * 左 max 小于 x
     * 右 min 大于 x
     *
     * 返回值结构 isSearchTree min max
     *
     * 具体代码看TestBST
     */

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        Node(int val) {
            this.val = val;
        }
    }


    public static boolean isSearchTree() {

    }

    public static class ReturnData {
        boolean isBST;
        int max;
        int min;

        public ReturnData(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static ReturnData process(Node x) {
        if (x == null) return null;
        int max = x.val;
        int min = x.val;
        ReturnData leftData = process(x.left);
        ReturnData rightData = process(x.right);
        if (leftData != null) {
            min = Math.min(min,leftData.min);
            max = Math.max(max,leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min,rightData.min);
            max = Math.max(max,rightData.max);
        }
        boolean isBST = true;
        if (leftData != null && (!leftData.isBST || leftData.max >= x.val)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.val)) {
            isBST = false;
        }
        return new ReturnData(isBST,max,min);
    }
}
