package com.bankle.org;

import java.util.Arrays;

public class MergeSort {
    static int[] nums = new int[]{
            1, 15, 3, 78,
            34, 23, 46, 2,
            8, 34, 57, 50,
            200, 123, 66, 43,
            33, 100, 356, 21};

    static int[] auxiliary = new int[nums.length];

    public static void main(String[] args) {


        System.out.println("before Bubble sort " + Arrays.toString(nums));
//        topToBottomSort(nums, 0, nums.length - 1);
        bottomToTopSort(nums);

        System.out.println("after Bubble sort " + Arrays.toString(nums));
    }

    public static void topToBottomSort(int[] nums, int low, int height) {
        if (low >= height) return;

        int mid = low + (height - low) / 2;

        topToBottomSort(nums, low, mid);// sort left
        topToBottomSort(nums, mid + 1, height);//sort right

        merge(nums, low, mid, height); // merge left and right
    }

    public static void bottomToTopSort(int[] nums) {
        final int N = nums.length;
        for (int size = 1; size < N; size = size + size) {//the size is length of sub array
            for (int low = 0; low < N - size; low += size + size) {
                merge(nums, low, low + size - 1, Math.min(low + size + size - 1, N - 1));
            }
        }
    }

    private static void merge(int[] a, int low, int mid, int height) {
        int i = low;
        int j = mid + 1;


        //copy the a to auxiliary
        for (int k = low; k <= height; k++) {
            auxiliary[k] = a[k];
        }

        //merge left and right
        for (int k = low; k <= height; k++) {
            if (i > mid) {
                a[k] = auxiliary[j++];
            } else if (j > height) {
                a[k] = auxiliary[i++];
            } else if (a[i] >= a[j]) {
                a[k] = auxiliary[j++];
            } else {
                a[k] = auxiliary[i++];
            }
        }
    }
}
