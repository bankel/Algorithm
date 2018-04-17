package com.bankle.org;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 15, 3, 78, 34, 23, 46, 2, 8, 34, 57};
        System.out.println("before Shell sort " + Arrays.toString(nums));
        sort(nums);
        System.out.println("after Shell sort " + Arrays.toString(nums));
    }

    public static void sort(int[] arrays) {
        int n = arrays.length;

        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {

            for (int i = h; i < n; i++) {

                for (int j = i; j >= h && arrays[j] < arrays[j - h]; j = j - h) {

                    int temp = arrays[j];
                    arrays[j] = arrays[j - h];
                    arrays[j - h] = temp;
                }
            }

            h = h / 3;
        }

    }

}
