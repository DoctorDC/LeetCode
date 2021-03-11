package com.example.mathdemo.book;

public class Code03_WaterAndDp {

    public static int getWater(int[] a) {
        int n = a.length;
        int left = 1;
        int right = n - 2;
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


    /**
     * 给定一个只有小写字母a-z组成的字符串str
     * 返回最长无重复字符的字串长度
     *
     *
     * 两个瓶颈 谁离i位置近，谁就是瓶颈
     * 1.一个 i位置 上次i出现的位置
     * 2.i-1 字符有重复
     *
     */
    public static int lnrs2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] str = s.toCharArray();
        int N = str.length;
        /**
         * 0 a
         * 1 b
         * 2 c 上次出现的位置
         */
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        //dp[0] =1
        last[str[0] - 'a'] = 0;
        int max = 1;
        int preMaxLen = 1;//dp[i-1]
        for (int i = 1; i < N; i++) {
            preMaxLen = Math.min(i - last[str[i] - 'a'], preMaxLen + 1);
            max = Math.max(max, preMaxLen);
            last[str[i] - 'a'] = i;
        }
        return max;
    }

}
