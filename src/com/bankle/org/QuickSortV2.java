package com.bankle.org;

import com.bankle.org.utils.RandomSequence;

public class QuickSortV2 {

    public static void main(String[] args) {

        int[] nums = RandomSequence.retrieveSequence();
        long previousTime = System.currentTimeMillis();
        sort(nums, 0, nums.length - 1);
        System.out.println("Quick sort cost " + (System.currentTimeMillis() - previousTime));

    }

    public static void sort(int[] array, int low, int height) {
//        if (low >= height) return;
        if (low + 10 >= height) {// fast then original quick sort about 200ms at size of 1<<24
            InsertSort.sort(array, low, height);
            return;
        }

        int j = partition(array, low, height);

        sort(array, low, j - 1);

        sort(array, j + 1, height);
    }


    private static int partition(int[] array, int low, int height) {
        //partition the array to array[low]...a[j-1], a[j], a[j+1]...a[height]
        int i = low;
        int j = height + 1;

        int value = array[low];// the partition value

        //exchange the left and right along with scan
        int temp;
        while (true) {
            while (array[++i] <= value) if (i >= height) break;
            while (array[--j] >= value) if (j <= low) break;
            if (i >= j) break;

            //exchange the array[i] and array[j]
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        //exchange the array[low] and array[j]
        temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

}
