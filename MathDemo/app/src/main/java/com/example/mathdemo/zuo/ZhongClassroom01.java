package com.example.mathdemo.zuo;

public class ZhongClassroom01 {
    /**
     * 装苹果 n
     * 6个和 8个袋子 求一共几个袋子
     *
     * 24是 6 和 8的最小公倍数
     */

    public static int appleMinBags(int apple) {
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - bag8;
        int sum = -1;
        while (bag8 >= 0 && rest < 24) {
            int restBag6 = appleMinBag6(rest);
            if (restBag6 != -1) {
                sum = bag6 + bag8;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return sum;
    }

    private static int appleMinBag6(int apple) {//返回容量6的袋子个数
        return apple % 6 == 0 ? apple / 6 : -1;
    }

    /**
     *
     */
}
