package com.example.mathdemo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by xty on 21-2-22.
 * <p>
 * 这里是b站 爱学习的饲养员
 *
 * 1.按知识点刷题
 * 2.刷经典题  top 100
 *
 * 70道
 * 数组：485/283/27
 * 链表：203/206
 * 队列：933/225/622/641
 * 栈：20/496/232
 * 哈希表：271/289/496
 * 集合set：217/705
 * 堆：215/692
 * 树和图
 *
 * 算法*
 * 双指针：141/344/881
 * 二分找出法：704/35/162/74
 * 滑动窗口：209/1456
 * 递归：509/206/344/687
 * 分治算法：169/53
 * 回溯算法：22/78/77/46
 * 深度优先搜索 DFS: 938/78/200
 * 宽度优先搜索 BFS: 102/107/200
 * 并查集：200/547/72
 * 贪心算法：322/1217/55
 * 记忆化搜索：509/322
 * 动态规划：509/62/121/70/279/221
 * 拓扑排序：207/210
 * 前缀树：208/720/692
 *
 */
public class LeetCode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 1 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     */

    //key 某个之前的数 value这个数出现的位置
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum2(int[] nums, int target) {
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
     * 解法：
     * 数组有序，相撞指针
     */

    public static int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            res = res + 1;
        }
        return res;
    }

    /**
     * 二分查找法 704 35 162 74
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     */

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int mid2 = left + (right - left) / 2;//取中间值
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;

    }

    /**
     * 35 搜索插入位置
     * <p>
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * https://leetcode-cn.com/problems/search-insert-position/
     */

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] > target) {
            return left;
        } else {
            return left + 1;
        }
    }

    /**
     * 162. 寻找峰值
     * 峰值元素是指其值大于左右相邻值的元素。
     * <p>
     * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * <p>
     * 链接：https://leetcode-cn.com/problems/find-peak-element
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     */

    /**
     * 滑动窗口
     */
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     */
    public static int minSubArrayLen(int target, int[] nums) {
        return -1;
    }

    /**
     * 141 环形链表
     * 快慢指针
     */

    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = head.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static boolean hasCycle2(Node head) {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 485.给定一个二进制数组， 计算其中最大连续 1 的个数。
     * <p>
     * 输入：[1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        nums[0] = nums[0] == 0 ? 0 : 1;
        res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 0;
            }
            res = Math.max(res, nums[i]);

        }
        return res;
    }
}