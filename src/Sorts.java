/*
 * NAME: Christian Guerra
 * PID:  A17660168
 */

//Provided imports, feel free to use these if needed
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Sorts {

    public static void InsertionSort(int[] list, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int temp = list[i];
            int j = i - 1;
            while (j >= start && list[j] > temp) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
    }


    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<Integer> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param m the middle index we want to merge
     * @param r right-most index we want to merge
     */
    private void merge(ArrayList<Integer> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<Integer> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    public static void QuickSort(int[] list, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(list, start, end);
            QuickSort(list, start, pivotIndex -1);
            QuickSort(list, pivotIndex + 1, end);
        }
    }


    public static int partition(int[] arr, int l, int h) {
        int pivotIndex = (l + h) / 2;
        int pivotValue = arr[pivotIndex];
        // Move pivot to the end of the array
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[h];
        arr[h] = temp;
        int i = l;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivotValue) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        // Move pivot to its final position
        temp = arr[i];
        arr[i] = arr[h];
        arr[h] = temp;
        return i;
    }

    // TODO
    public void Modified_QuickSort(ArrayList<Integer> list, int start, int end, int cutoff) {
        // TODO
    }

    /**
     * this helper finds the appropriate number of buckets you should allocate
     * based on the range of the values in the input list
     * @param list the input list to bucket sort
     * @return number of buckets
     */
    private int assignNumBuckets(ArrayList<Integer> list) {
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        return (int) Math.sqrt(max - min) + 1;
    }

    /**
     * this helper finds the appropriate bucket index that a data should be
     * placed in
     * @param data a particular data from the input list if you are using
     *             loop iteration
     * @param numBuckets number of buckets
     * @param listMin the smallest element of the input list
     * @return the index of the bucket for which the particular data should
     * be placed in
     */
    private int assignBucketIndex(Integer data, int numBuckets, Integer listMin) {
        return (data - listMin) / numBuckets;
    }

    // TODO
    public ArrayList<Integer> bucketSort(ArrayList<Integer> list) {
        // TODO
        return new ArrayList<Integer>();
    }


    public static int[] countSort(int[] list) {
        int max = Arrays.stream(list).max().orElse(0);
        int[] counts = new int[max + 1]; // Initialize an array to count occurrences
        for (int i = 0; i < list.length; i++) {
            counts[list[i]]++; // Count occurrences
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                list[index++] = i; // Fill the array with the sorted values
            }
        }
        return list;
    }
}