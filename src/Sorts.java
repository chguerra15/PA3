/*
 * NAME: Christian Guerra
 * PID:  A17660168
 */

//Provided imports, feel free to use these if needed
import java.util.Collections;
import java.util.ArrayList;
//Class sorts, contains many sorting methods
public class Sorts {

    /**
     * This method performs insertion sort on a subsection of the input ArrayList
     *
     * @param list The ArrayList we want to sort
     * @param start The initial index of the subsection we want to sort
     * @param end The final index of the subsection we want to sort
     */
    public static void insertionSort(ArrayList<Integer> list, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= start && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * This method performs merge sort on a subsection of the input ArrayList
     *
     * @param list The ArrayList we want to sort
     * @param start The initial index of the subsection we want to sort
     * @param end The final index of the subsection we want to sort
     */
    public void MergeSort(ArrayList<Integer> list, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            // recursively sort the left and right halves of the array
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            // merge the two sorted halves
            merge(list, start, mid, end);
        }
    }

    /**
     * Merge helper function for MergeSort
     *
     * @param arr The ArrayList we want to sort
     * @param l The left-most index we want to merge
     * @param m The middle index we want to merge
     * @param r The right-most index we want to merge
     */
    private void merge(ArrayList<Integer> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<Integer> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        // merge the two halves of the array
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            } else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        // append any remaining elements from the left and right halves
        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }

        // copy the merged elements back into the original array
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs quicksort on a subsection of the input ArrayList
     *
     * @param list The ArrayList we want to sort
     * @param start The initial index of the subsection we want to sort
     * @param end The final index of the subsection we want to sort
     */
    public static void QuickSort(ArrayList<Integer> list, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(list, start, end);
            QuickSort(list, start, pivotIndex -1);
            QuickSort(list, pivotIndex + 1, end);
        }
    }

    /**
     * This method helps the Quick Sort method by choosing a Pivot Index for them
     * @param list The ArrayList we want to sort
     * @param start The initial index of the subsection we want to sort
     * @param end The final index of the subsection we want to sort
     */
    public static int partition(ArrayList<Integer> list, int start, int end) {
        int partition = 2;
        int pivotIndex = (start + end) / partition;
        int pivotValue = list.get(pivotIndex);
        // Move pivot to the end of the array
        int temp = list.get(pivotIndex);
        list.set(pivotIndex, list.get(end));
        list.set(end, temp);
        int i = start;
        for (int j = start; j < end; j++) {
            if (list.get(j) < pivotValue) {
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }
        // Move pivot to its final position
        temp = list.get(i);
        list.set(i, list.get(end));
        list.set(end, temp);
        return i;
    }

    /**
     * This method performs Modified quicksort on a subsection of the input ArrayList
     * @param list The ArrayList we want to sort
     * @param start The initial index of the subsection we want to sort
     * @param end The final index of the subsection we want to sort
     * @param cutoff A set number to cut the array into
     * @return sorted list from the input
     */
    public static void Modified_QuickSort(ArrayList<Integer> list, int start, int end, int cutoff){
        if (end - start + 1 <= cutoff) {
            insertionSort(list, start, end);
        } else {
            //Recursive call to calculate each unsorted array
            int pivotIndex = partition(list, start, end);
            Modified_QuickSort(list, start, pivotIndex - 1, cutoff);
            Modified_QuickSort(list, pivotIndex + 1, end, cutoff);
        }
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

    /**
     * This Method is one of the sorting methods for a list, separates a sequence by allocating them
     * in a specific number of buckets and applies Insertion Sorts to those unsorted sequences
     * @param list the input list to bucket sort
     * @return the sorted list from the input
     */
    public ArrayList<Integer> bucketSort(ArrayList<Integer> list) {
        int min = Collections.min(list);
        int numBuckets = assignNumBuckets(list);
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(); // Loop assigns the number of buckets
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int data : list) {
            int bucketIndex = assignBucketIndex(data, numBuckets, min);
            buckets.get(bucketIndex).add(data);
        }
        for (ArrayList<Integer> bucket : buckets) { // Sorts each bucket using the insertion sort
            insertionSort(bucket, 0, bucket.size() - 1);
        }
        ArrayList<Integer> sortedList = new ArrayList<>(); // Merge the sorted buckets back into the original list
        for (ArrayList<Integer> bucket : buckets) {
            sortedList.addAll(bucket);
        }
        return sortedList;
    }

    /**
     * Count Sort method, creates an array from 0 to the largest number in the data, counts the
     * number of sequences in that array and returns a sorted list
     * @param list the input of the method, list to be sorted
     * @return returns the final sorted list
     */
    public static ArrayList<Integer> countSort(ArrayList<Integer> list) {
        //obtains the maximum value of the list
        int max = Collections.max(list);
        //creates an empty array from 0 to the the maximum value
        int[] counts = new int[max + 1];
        ArrayList<Integer> sortedList = new ArrayList<>();
        //Calculates number of sequences
        for (int i = 0; i < list.size(); i++) {
            counts[list.get(i)]++;
        }
        for (int i = 0; i <= max; i++) {//adds the sequences to the empty array
            for (int j = 0; j < counts[i]; j++) {
                sortedList.add(i);
            }
        }
        return sortedList;
    }
}