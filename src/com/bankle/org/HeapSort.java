package com.bankle.org;

import com.bankle.org.utils.RandomSequence;

public class HeapSort {


    public static void main(String[] args) {
        int[] nums = RandomSequence.retrieveSequence();
        long previousTime = System.currentTimeMillis();
        sort(nums);
        System.out.println("Quick sort cost " + (System.currentTimeMillis() - previousTime));

    }

    public static void sort(int[] array) {
        //heap construction
        int length = array.length;

        for (int k = length / 2; k >= 1; k--)
            sink(array, k, length);

        //sort array
        while (length > 1) {
            exchange(array, 1, length--);
            sink(array, 1, length);
        }


    }

    private static void sink(int[] array, int p, int length) {
        while (2 * p <= length) {
            int child = 2 * p;
            if (child < length && less(array, child, child + 1)) child++;

            if (!less(array, p, child)) break;
            exchange(array, p, child);

            p = child;//move to next layer
        }


    }


    private static boolean less(int[] array, int j, int k) {
        return array[j - 1] < array[k - 1];
    }

    private static void exchange(int[] array, int j, int k) {
        int temp = array[j - 1];
        array[j - 1] = array[k - 1];
        array[k - 1] = temp;
    }

}
