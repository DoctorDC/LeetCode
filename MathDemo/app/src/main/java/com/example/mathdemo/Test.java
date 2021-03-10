package com.example.mathdemo;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    /**
     * 1 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     * 链接：https://leetcode-cn.com/problems/two-sum
     */

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * 881 救生艇
     * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/boats-to-save-people
     * <p>
     * [1,2,2,3,4,5] limit = 5;
     * 解法：
     * 数组有序，相撞指针
     */
    public static int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) return 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res++;
        }
        return res;
    }

    /**
     * 平衡二叉树
     * 左右平衡，相减 <2
     */

    private class Node {
        public int val;
        public Node left;
        public Node right;

        Node(int val) {
            this.val = val;
        }
    }

    private boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public class ReturnType {
        int height;
        public boolean isBalanced;

        public ReturnType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private ReturnType process(Node x) {
        if (x == null)
            return new ReturnType(0, true);
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int h = Math.max(leftData.height, rightData.height) + 1;
        boolean b = leftData.isBalanced && rightData.isBalanced &&
                (Math.abs(leftData.height - rightData.height) < 2);
        return new ReturnType(h, b);
    }

    /**
     * 搜索二叉树 isbst min max
     * 它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
     */
    public class ReturnSearchTree {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnSearchTree(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public ReturnSearchTree processSearch(Node x) {
        if (x == null) return null;
        ReturnSearchTree leftData = processSearch(x.left);
        ReturnSearchTree rightData = processSearch(x.right);
        boolean isBst = true;
        int min = x.val;
        int max = x.val;

        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }

        if (leftData != null && (!leftData.isBST || leftData.max >= x.val)) {
            isBst = false;
        }
        if (rightData != null && (!rightData.isBST || x.val >= rightData.min)) {
            isBst = false;
        }

        return new ReturnSearchTree(isBst, min, max);
    }

    /**
     * 满二叉树 树高度，节点个数
     * 一个二叉树，如果每一个层的结点数都达到最大值，则这个二叉树就是满二叉树
     * 也就是说，如果一个二叉树的层数为K，且结点总数是(2^k) -1 ，则它就是满二叉树。
     */
    private class ReturnFullTree {
        public int height;
        public int nodes;

        public ReturnFullTree(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public ReturnFullTree processFull(Node x) {
        if (x == null)
            return new ReturnFullTree(0, 0);
        ReturnFullTree left = processFull(x.left);
        ReturnFullTree right = processFull(x.right);
        int treeH = Math.max(left.height, right.height) + 1;
        int node = left.nodes + right.nodes + 1;
        return new ReturnFullTree(treeH, node);

    }

    //岛屿
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(grid, x - 1, y, row, col);
        dfs(grid, x + 1, y, row, col);
        dfs(grid, x, y - 1, row, col);
        dfs(grid, x, y + 1, row, col);
    }

    private int water(int[] a) {
        int n = a.length;
        int left = 0;
        int right = n - 1;
        int leftMax = a[0];
        int rightMax = a[n - 1];
        int sum = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                sum += Math.max(0, leftMax - a[left]);
                leftMax = Math.max(leftMax, a[left++]);
            } else {
                sum += Math.max(0, rightMax - a[right]);
                rightMax = Math.max(rightMax, a[right--]);
            }
        }
        return sum;
    }


}
