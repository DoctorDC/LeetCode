package com.example.mathdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leetcode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] ss = new int[]{3, 1, 4, 2, 4};
        test(ss);
        Log.d("1234", "ss==" + Arrays.toString(ss));

        int[] aa = new int[]{1, 1, 0, 1, 1, 1,1,1,0};
        int sum = LeetCode.findMaxConsecutiveOnes2(aa);
        Log.d("1234", "aa==" +sum);


    }

    private void test(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}