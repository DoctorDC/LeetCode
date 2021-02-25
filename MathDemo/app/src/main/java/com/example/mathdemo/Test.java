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




}
