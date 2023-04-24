import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    @Test
    void insertionSort() {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        Sorts.insertionSort(list1, 0, 4);
        ArrayList<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected1, list1);

        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(10, 8, 6, 4, 2));
        Sorts.insertionSort(list2, 1, 3);
        ArrayList<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(10, 4, 6, 8, 2));
        assertEquals(expected2, list2);

        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Sorts.insertionSort(list3, 2, 4);
        ArrayList<Integer> expected3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected3, list3);
    }

    @Test
    void quickSort() {
        ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Sorts.QuickSort(list3, 2, 4);
        ArrayList<Integer> expected3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected3, list3);

        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(10, 8, 6, 4, 2));
        Sorts.QuickSort(list2, 0, 4);
        ArrayList<Integer> expected2 = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10));
        assertEquals(expected2, list2);

        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        Sorts.QuickSort(list1, 0, 4);
        ArrayList<Integer> expected1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(expected1, list1);


    }

    @Test
    void partition() {

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 4, 8, 7, 5));
        Sorts.QuickSort(list2, 0, list2.size() - 1);
        assertEquals(Arrays.asList(1, 3, 4, 5, 7, 8), list2);

        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(3, 1, 4, 8, 7, 5));
        Sorts.QuickSort(list4, 0, list4.size() - 1);
        assertEquals(Arrays.asList(1, 3, 4, 5, 7, 8), list4);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5, 6, 32, 6, 2));
        Sorts.QuickSort(list3, 0, list3.size() - 1);
        assertEquals(Arrays.asList(2, 5, 6, 6, 32), list3);
    }

    @Test
    void modified_QuickSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 8, 7, 5));
        Sorts.Modified_QuickSort(list, 0, list.size() - 1, 2);
        assertEquals(Arrays.asList(1, 3, 4, 5, 7, 8), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 3, 5, 3, 9));
        Sorts.Modified_QuickSort(list2, 0, list2.size() - 1, 2);
        assertEquals(Arrays.asList(3, 3, 4, 5, 9), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        Sorts.Modified_QuickSort(list3, 0, list3.size() - 1, 2);
        assertEquals(Arrays.asList(1, 2, 3), list3);
    }

    @Test
    void bucketSort() {
        ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(3, 2, 1));
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        Sorts s = new Sorts();
        ArrayList<Integer> actualOutput = s.bucketSort(input);
        assertEquals(expectedOutput, actualOutput);

        ArrayList<Integer> input1 = new ArrayList<Integer>(Arrays.asList(7, 5, 3, 1, 9, 8, 2, 4,
                6));
        ArrayList<Integer> expectedOutput1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5,
                6, 7, 8, 9));
        Sorts s1 = new Sorts();
        ArrayList<Integer> actualOutput1 = s1.bucketSort(input1);
        assertEquals(expectedOutput1, actualOutput1);

        ArrayList<Integer> input2 = new ArrayList<Integer>(Arrays.asList(1,4,5,6,2,4));
        ArrayList<Integer> expectedOutput2 = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 4, 5,
                6));
        Sorts s2 = new Sorts();
        ArrayList<Integer> actualOutput2 = s2.bucketSort(input2);
        assertEquals(expectedOutput2, actualOutput2);
    }

    @Test
    void countSort() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 1, 4, 8, 7, 5, 6, 2));
        ArrayList<Integer> sortedList1 = Sorts.countSort(list1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), sortedList1);
        // Test with duplicates
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 4, 8, 7, 5, 1, 7));
        ArrayList<Integer> sortedList2 = Sorts.countSort(list2);
        assertEquals(Arrays.asList(1, 1, 3, 4, 5, 7, 7, 8), sortedList2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        ArrayList<Integer> sortedList3 = Sorts.countSort(list3);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), sortedList3);
    }
}