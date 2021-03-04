package com.example.mathdemo.book;

import java.util.Arrays;

public class Code02_ContainAllCharExactly {

    //暴力
    public static int containExactly1(String s, String a) {
        if (s == null || a == null || s.length() < a.length())
            return -1;
        char[] aim = a.toCharArray();
        Arrays.sort(aim);
        String aimSort = String.valueOf(aim);
        for (int L = 0; L < s.length(); L++) {
            for (int R = L; R < s.length(); R++) {
                char[] cur = s.substring(L, R + 1).toCharArray();
                Arrays.sort(cur);
                String curSort = String.valueOf(cur);
                if (curSort.equals(aimSort))
                    return L;
            }

        }
        return -1;
    }


    public static int containExactly2(String s, String a) {
        if (s == null || a == null || s.length() < a.length())
            return -1;
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        for (int i = 0; i <= str.length - aim.length; i++) {
            if (isCountEqual(str, i, aim))
                return i;
        }
        return -1;
    }


    public static boolean isCountEqual(char[] str, int L, char[] aim) {
        int[] count = new int[256];
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        for (int i = 0; i < aim.length; i++) {
            if (count[str[L + i]]-- == 0)
                return false;

        }
        return true;
    }


    public static boolean isTY(String A, String B) {
        if (A.length() != B.length())
            return false;

        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < str1.length; i++) {
            count[str1[i]]++;
        }
        for (int i = 0; i < str2.length; i++) {
            if (count[str2[i]]-- == 0)
                return false;

        }
        return true;
    }
    //只检测长度一样的


    public static int containExactly3(String s, String a) {
        if (s == null || a == null || s.length() < a.length())
            return -1;
        char[] aim = a.toCharArray();
        int[] count = new int[256];
        //建立一张表
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }

        int M = aim.length;
        char[] str = s.toCharArray();
        int inValidTimes = 0;//通过无效点数判断
        int R = 0;
        //先让窗口有M个字符
        for (; R < M; R++) {
            if (count[str[R]]-- <= 0)
                inValidTimes++;
        }
        if (inValidTimes == 0)
            return R- M;//第一个窗口就是
        //R==M
        //[0..M-1]
        for (; R < str.length; R++) {
            if (inValidTimes == 0)
                return R - M;
            //[1 .. M]
            //[2 .. M+1]
            if (count[str[R]]-- <= 0)
                inValidTimes++;//右侧进窗口，借一个如果进窗口前表中值是
            if (count[str[R - M]]++ < 0) //左侧出窗口，还一个
                inValidTimes--;
        }
        return inValidTimes == 0 ? R - M : -1;//最后一个窗口
    }
}
