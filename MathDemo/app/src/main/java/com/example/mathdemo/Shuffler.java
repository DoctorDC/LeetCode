package com.example.mathdemo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Shuffler {

    public static void shuffle(int[] poker) {
        Thread huang = new Thread() {
            public void run() {


                huang.interrupt();//打断lin线程
            }
        };
        for (int i = 0; i < poker.length; ++i) {
            Thread a = new Thread() {
                @Override
                public void run() {
                    super.run();
                    poker[i] = getRandom(i);
                }
            };
            a.start();


        }






    }

    // 以下部分不能修改

    public static final int POKER_SIZE = 54;

    public static void test() {
        int[] poker = new int[POKER_SIZE];
        for (int i = 0; i < poker.length; ++i) {
            poker[i] = i;
        }

//        long time = getUpTime();
        shuffle(poker);
        System.out.println(Arrays.toString(poker));
//        System.out.println(
//                String.format("take time:%dms, correct?%b", getUpTime() - time, verify(poker)));
    }

    /**
     * 返回一个[0, bound)的随机数，此随机数方法调用一次耗时1s
     */
    private static int getRandom(int bound) {
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return new java.util.Random().nextInt(bound);
    }

//    private static long getUpTime() {
//        java.lang.management.RuntimeMXBean bean =
//                java.lang.management.ManagementFactory.getRuntimeMXBean();
//        return bean.getUptime();
//    }

    private static boolean verify(int[] poker) {
        if (poker == null || poker.length != POKER_SIZE) {
            return false;
        }

        return Arrays.stream(poker).filter(n -> n >= 0 && n < POKER_SIZE).boxed()
                .collect(Collectors.toSet()).size() == POKER_SIZE;
    }
}
