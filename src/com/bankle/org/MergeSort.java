package com.bankle.org;

import com.bankle.org.utils.RandomSequence;

public class MergeSort {

    static int[] auxiliary;

    public static void main(String[] args) {

        int[] nums = RandomSequence.retrieveSequence();
        auxiliary = new int[nums.length];
        long previousTime = System.currentTimeMillis();
        bottomToTopSort(nums);
        System.out.println("Merge sort cost " + (System.currentTimeMillis() - previousTime));

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
