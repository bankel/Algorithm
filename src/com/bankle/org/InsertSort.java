package com.bankle.org;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 15, 3, 78, 34, 23, 46, 2, 8, 34, 57};
        System.out.println("before Insert sort "+Arrays.toString(nums));
        sort(nums);
        System.out.println("after Insert sort "+ Arrays.toString(nums));
    }

    public static void sort(int[] arrays) {
        for(int i=1 ; i< arrays.length; i++) {

            int j = i;//record the index of start

            for(; j> 0; j--) {
                if (arrays[j] < arrays[j -1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j -1] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
