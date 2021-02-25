package com.example.mathdemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BriTree {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 124442555213666377731
     * 先（头左右） 1245367 第一次遇到打印
     * 中 （左头右） 4251637 第二次遇到
     * 后（左右头） 4526731 第三次遇到
     *
     * 通过递归，选择打印时机
     */

    /**
     * 先序(深度优先遍历)
     * 1.从栈中弹出一个节点
     * 2.打印
     * 3.先右再左
     */
    public static void preOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void preOrderUnRecur2(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 后序遍历
     * 两个栈
     * 1.弹cur
     * 2.cur 放入收栈
     * 3.先左再右
     */

    public static void posOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) { //从收集栈打印
                System.out.print(s2.pop().val + " ");
            }
        }
    }

    /**
     * 中序遍历
     * 整个数左边界进栈
     * 依次弹出过程中，打印，
     * 对弹出节点右树 循环
     */
    public static void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void inOrderUnRecur2(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head.left);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 二叉树宽度(队列)
     * 加入队列
     * 弹出打印
     * 先左再右
     * <p>
     * 用map存哪层
     */
    public static void treeGo(TreeNode head) {
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1; //当前在哪层
        int curLevelNodes = 0; //当前层有几个节点
        int max = Integer.MIN_VALUE; //所有层中最多的点
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
//            System.out.print(cur.val + " ");
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
    }

    public static void w2(TreeNode head) {
        if (head == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = -1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //判断当前节点层
            int tmpLevel = map.get(cur);
            if (curLevel == tmpLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if (cur.left != null) {
                map.put(cur.left, tmpLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, tmpLevel + 1);
                queue.add(cur.right);
            }
        }
    }

    /**
     * 搜索二叉树 ：左中右 小到大dp
     * 完全二叉树
     * 满二叉树 2^l-1 dp
     * 平衡二叉树：avl dp
     * 它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     */

    public static int preValue = Integer.MIN_VALUE;

    // 打印时机变成比较时机
    public static boolean isBST(TreeNode head) {
        if (head == null) return true;
        boolean isLeftBst = isBST(head.left);
        if (!isLeftBst)
            return false;
        if (head.val <= preValue) {
            return false;
        } else {
            preValue = head.val;
        }
        return isBST(head.right);

    }

    /**
     * 完全二叉树
     * <p>
     * 宽度
     * 队列，两个lr
     * 1.任意一个节点，有右无左 false
     * 2.遇到第一个左右两个孩子不全，后面节点皆叶 才是完全二叉树，否则不是。
     */
    public static boolean isCBT(TreeNode head) {
        if (head == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode l = null;
        TreeNode r = null;
        boolean leaf = false;//是否遇到左右两个孩子不双全节点
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (leaf && (l != null || r != null) ||
                    (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {//两个孩子有一个不全
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCBT2(TreeNode head) {
        if (head == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode l = null;
        TreeNode r = null;
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if (leaf && (l != null || r != null) ||
                    (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCBT3(TreeNode head) {
        if (head == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if (leaf && (l != null || r != null) ||
                    (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 二叉树套路
     * <p>
     * 平衡二叉树
     * 左右树平衡，差小于2
     * <p>
     * 树型dp 左右
     */
    public static boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    //返回值的结构
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnType process(TreeNode x) {
        if (x == null) { //base
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalanced, height);

    }


    /**
     * 给的两个二叉树节点node1 node2,找出他们的最低公共祖先节点
     * <p>
     * o1 和 o2一定属于head为头的树
     * 返回o1 o2 的最低公共祖先
     */

    public static TreeNode lca(TreeNode head, TreeNode o1, TreeNode o2) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = o1;
        while (cur != fatherMap.get(cur)) { //不是头节点
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        TreeNode cur2 = o2;
        while (cur2 != fatherMap.get(cur2)) {
            if (set1.contains(cur2)) {
                return cur2;
            }

        }
        return null;
    }

    public static void process(TreeNode head, HashMap<TreeNode, TreeNode> fatherMap) {
        if (head == null) return;
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    /**
     * 938 leetcode
     * 二叉搜索树的范围和
     * bfs 使用queue
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }

            }
        }
    }

    /**
     * 107
     */
}
