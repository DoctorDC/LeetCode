package com.example.mathdemo.book;

import com.example.mathdemo.BriTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code04_BriTree {
    /**
     * 二叉树按层遍历并收集每层节点
     */

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> curAns = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                curAns.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            ans.add(curAns);
        }
        return ans;
    }



}
