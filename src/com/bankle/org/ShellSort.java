package com.bankle.org;

import com.bankle.org.utils.RandomSequence;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = RandomSequence.retrieveSequence();
        long previousTime = System.currentTimeMillis();
        sort(nums);
        System.out.println("Quick sort cost " + (System.currentTimeMillis() - previousTime));
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
