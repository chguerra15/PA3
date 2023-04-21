import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    @org.junit.jupiter.api.Test
    void insertionSort() {
        int[] arr = {5, 3, 8, 4, 2};
        Sorts.InsertionSort(arr, 0, 4);
        assertArrayEquals(new int[] {2, 3, 4, 5, 8}, arr);
        int[] arr2 = {1, 2, 3, 4, 5};
        Sorts.InsertionSort(arr2, 0, 4);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr2);
        int[] arr3 = {5, 4, 3, 2, 1};
        Sorts.InsertionSort(arr3, 0, 4);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr3);

    }

    @org.junit.jupiter.api.Test
    void QuickSort() {
        int[] arr = {5, 3, 8, 4, 2};
        Sorts.QuickSort(arr, 0, 4);
        assertArrayEquals(new int[] {2, 3, 4, 5, 8}, arr);
        int[] arr2 = {4,5,6,1,3};
        Sorts.QuickSort(arr2, 0, 4);
        assertArrayEquals(new int[]{1, 3, 4, 5, 6}, arr2);
        int[] arr3 = {1, 1, 3, 4, 3, 1};
        Sorts.QuickSort(arr3, 0, 5);
        assertArrayEquals(new int[]{1, 1, 1, 3, 3, 4}, arr3);
        int[] arr4 = {};
        Sorts.QuickSort(arr4, 0, 0);
        assertArrayEquals(new int[]{}, arr4);
    }

    @org.junit.jupiter.api.Test
    void modified_QuickSort() {
    }

    @org.junit.jupiter.api.Test
    void bucketSort() {
    }

    @org.junit.jupiter.api.Test
    void countSort() {
        int[] input = {3, 1, 4, 2, 3, 5, 1, 2, 3, 4};
        int[] expectedOutput = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
        Sorts.countSort(input);
        assertArrayEquals(expectedOutput, input);
    }
}
