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


    private void swim(int[] array, int k) {
        while (k > 1 && less(array, k / 2, k)) {
            exchange(array, k, k / 2);
            k = k / 2;
        }
    }

    //assume the value of root node is the minimum
    private static void deleteMin(int[] array) {
        int length = array.length;
        int lastElement = array[length - 1];


        int child , k;
        for (k = 0; 2 * k < length; k = child) {
            child = 2 *k +1;
            if(child + 1 > length) break;
            if ( array[child] > array[child + 1]) child++;

            if (array[child] < lastElement) {
                array[k] = array[child];
            }
        }

        array[k] = lastElement;
        array[length - 1] = -1;
    }

}
