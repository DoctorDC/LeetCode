package com.example.mathdemo;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by xty on 21-3-3.
 */
public class ZuoCode {


    /**
     * 归并排序
     *
     * @param arr 要排序的数组
     * @param L   左边界
     * @param R   右边界
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];

        }

    }


    public static void process2(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process2(arr, L, mid);
        process2(arr, mid + 1, R);
        merge2(arr, L, mid, R);
    }

    public static void merge2(int[] arr, int L, int M, int R) {
        int p1 = L;
        int p2 = M + 1; //将数组分成两部分 L~M  M+1~R
        int help[] = new int[R - L + 1];//数组
        int i = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }

        //数组两个部分长度不相等情况，需要对没有遍历的部分继续遍历
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

//        Log.d("1234", "help==" + Arrays.toString(help));
        for (i = 0; i < help.length; i++) {
//            Log.d("1234","i=="+i+",L=="+L+",help=="+help[i]);
//            Log.d("1234","########");
            arr[L + i] = help[i];
        }

    }
}
