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
    void quickSort() {
    }

    @org.junit.jupiter.api.Test
    void modified_QuickSort() {
    }

    @org.junit.jupiter.api.Test
    void bucketSort() {
    }

    @org.junit.jupiter.api.Test
    void countSort() {
    }
}