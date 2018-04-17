package com.bankle.org;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 15, 3, 78, 34, 23, 46, 2, 8, 34, 57};
        System.out.println("before Bubble sort "+ Arrays.toString(nums));
        sort(nums);
        System.out.println("after Bubble sort "+ Arrays.toString(nums));
    }

    public static void sort(int[] arrays) {
        int length = arrays.length;
        for(int i=0; i< length; i++) {

            for(int j = length -1; j>0; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j-1];
                    arrays[j-1] = temp;
                }

            }

        }

    }
}
