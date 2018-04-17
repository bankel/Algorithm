package com.bankle.org;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 15, 3, 78, 34, 23, 46, 2, 8, 34, 57};
        System.out.println("before Select sort " + Arrays.toString(nums));
        sort(nums);
        System.out.println("before Select sort " + Arrays.toString(nums));
    }

    public static void sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int min = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[min] > arrays[j]) min = j;
            }

            //exchange the min and current arrays[i]
            if (min != i) {
                int temp = arrays[i];
                arrays[i] = arrays[min];
                arrays[min] = temp;
            }
        }
    }

}
