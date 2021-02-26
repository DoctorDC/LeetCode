package com.example.mathdemo;

/**
 * 排序算法
 */
public class FuncSort {

    /**
     * 选择 n^2
     * 冒泡，n^2
     * 插入，n^2
     * 堆，nlog2n
     * 希尔 n^1.3
     * 归并, nlog2n
     * 快排 nlog2n
     */
    /**
     * 选泡插，
     * 快归堆希统计基，
     * 恩放恩老恩一三，
     * 对恩加K恩乘K，
     * 不稳稳稳不稳稳，
     * 不稳不稳稳稳稳！
     */
    /**
     * 简单到复杂
     * 先局部后整体
     * 先粗糙后精细
     */
    /**
     * 交换函数
     */

    private static void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private static void swap2(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 选择排序
     * 两边for，先取出第一位
     * 然后和j比较
     */

    public static void selectionSort2(int[] a) {
        if (a != null || a.length < 2) return;
        for (int i = 0; i < a.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minPos] > a[j]) {
                    minPos = j;
                }
            }
            swap2(a, i, minPos);
        }
    }

    /**
     * 冒泡排序
     * 1.先确定最大范围 i--
     * 2.然后比较 j 和 j+1
     */
    public static void bubbleSort(int[] a) {
        if (a == null || a.length < 2) return;
        int n = a.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] a) {
        if (a != null || a.length < 2) return;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap2(a, i, j);
                }
            }

        }
    }

    /**
     * 插入排序
     * 先抽出第一张牌
     * 拿第一张牌和其他牌比较
     */

    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1])
                    swap2(a, j, j - 1);
            }
        }
    }

    /**
     * 希尔排序
     * 选择间隔插入排序
     */

    public static void insertSerSort(int[] a) {
        int gap = 4;
        int h = 1;
        while (h <= a.length / 3) {//确定gap大小
            h = h * 3 + 1;
        }
        for (gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (a[j] < a[j - gap]) {
                        swap2(a, j, j - gap);
                    }
                }
            }
        }
    }

    /**
     * 归并排序
     * 用两个排序好的数组
     * 分两半，左边右边排序
     * 1,3,5,6,7,8,9
     * <p>
     * 两个数组，if i <j i赋值给k，i++
     * <p>
     * 1.找出中间值mid 创建temp数组左右指针 i 和 j
     * 2.边界条件 i <= mid j <length
     * 3.谁小就把谁赋值给temp数组
     * 4.最后要追加 追加条件就是while的条件
     * <p>
     * 拓展 带边界的a[],left,right,rightBound
     */
    public static void mergeSort(int[] a) {
        int mid = a.length / 2;
        int temp[] = new int[a.length];
        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j < a.length) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) temp[k++] = a[i++];//这个地方是while，一直比较
        while (j < a.length) temp[k++] = a[j++];

    }

    public static void mergeSort2(int[] a) {
        int mid = a.length / 2;
        int temp[] = new int[a.length];
        int i = 0;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j < a.length) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i<=mid) temp[k++]=a[i++];
        while (j<a.length) temp[k++]=a[j++];
    }

    /**
     * 快速排序
     */

    public static void quickSort(int[] a, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int index = a[left];
        int temp = 0;
        while (i < j) {
            while (i < j && a[j] >= index)
                j--;
            while (i < j && a[i] <= index)
                i++;
            if (a[i] > a[j]) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            a[left] = a[i];
            a[i] = index;
        }
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }


}
