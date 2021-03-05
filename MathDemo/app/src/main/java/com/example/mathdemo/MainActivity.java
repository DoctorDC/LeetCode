package com.example.mathdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mathdemo.book.Code02_ContainAllCharExactly;

import java.util.Arrays;

import static com.example.mathdemo.book.Code02_ContainAllCharExactly.containExactly1;
import static com.example.mathdemo.book.Code02_ContainAllCharExactly.containExactly2;
import static com.example.mathdemo.book.Code02_ContainAllCharExactly.containExactly3;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "leetcode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] ss = new int[]{3, 1, 4, 2, 5};
        ZuoCode.process2(ss,0,ss.length-1);
//        Log.d("1234", "ss==" + Arrays.toString(ss));

        int[] aa = new int[]{1,2,3,4,5};
        int left = 0;
        int right = aa.length-1;
        int mid = left + ((right - left) >> 1);

        int t = aa[mid];
        Log.d("1234","mid=="+mid);
        Log.d("1234","t=="+t);
//        int[] aa = new int[]{1, 1, 0, 1, 1, 1, 1, 1, 0};
//        int sum = StudyGirl.findMaxConsecutiveOnes2(aa);
//        Log.d("1234", "aa==" + sum);
//
//        int[] bb = new int[]{2,3,1,2,4,3};
//        int i = StudyGirl.minSubArrayLen(7, bb);
//        Log.d(TAG, "onCreate: "+i);
//
//        String dd = "abccd";
//        int pp = HighFreeCode.lengthOfLongestSubstring2(dd);
//        Log.d(TAG, "onCreate: pp=="+pp);

    }

    //冒泡排序
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