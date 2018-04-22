package com.bankle.org;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 15, 3, 78, 34, 23, 46, 2, 8, 34, 57};
        System.out.println("before Insert sort " + Arrays.toString(nums));
//        sort(nums);
        sort(nums, 6, 10);
        System.out.println("after Insert sort " + Arrays.toString(nums));
    }

    public static void sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {

            int j = i;//record the index of start

            for (; j > 0 && arrays[j] < arrays[j - 1]; j--) {

                int temp = arrays[j];
                arrays[j] = arrays[j - 1];
                arrays[j - 1] = temp;

            }
        }
    }

    /**
     * sort array between low and height
     *
     * @param array
     * @param low
     * @param height
     */
    public static void sort(int[] array, int low, int height) {
        for (int i = low + 1; i <= height; i++) {

            int j = i;
            for (; j > i - 1 && array[j] < array[j - 1]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }

        }


    }

}
