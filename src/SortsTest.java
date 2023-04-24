import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    @Test
    void insertionSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 9, 1, 8));
        Sorts s = new Sorts();
        s.InsertionSort(list, 0, list.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 5, 7, 8, 9), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 5, 7, 2, 5));
        Sorts s2 = new Sorts();
        s2.InsertionSort(list2, 0, list2.size() - 1);
        assertEquals(Arrays.asList(2, 3, 5, 5, 7), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        Sorts s3 = new Sorts();
        s3.InsertionSort(list3, 0, list3.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3), list3);
    }

    @Test
    void quickSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 9, 1, 8));
        Sorts s = new Sorts();
        s.QuickSort(list, 0, list.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 5, 7, 8, 9), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 5, 7, 2, 5));
        Sorts s2 = new Sorts();
        s2.QuickSort(list2, 0, list2.size() - 1);
        assertEquals(Arrays.asList(2, 3, 5, 5, 7), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        Sorts s3 = new Sorts();
        s3.QuickSort(list3, 0, list3.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3), list3);


    }


    @Test
    void modified_QuickSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 9, 1, 8));
        Sorts s = new Sorts();
        s.Modified_QuickSort(list, 0, list.size() - 1, 4);
        assertEquals(Arrays.asList(1, 2, 3, 5, 7, 8, 9), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(8, 7, 6));
        Sorts s2 = new Sorts();
        s2.Modified_QuickSort(list2, 0, list2.size() -1, 2);
        assertEquals(Arrays.asList(6, 7, 8), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(8, 7, 6, 6));
        Sorts s3 = new Sorts();
        s3.Modified_QuickSort(list3, 0, list3.size() -1, 2);
        assertEquals(Arrays.asList(6, 6, 7, 8), list3);

    }

    @Test
    void bucketSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 9, 1, 8));
        Sorts s = new Sorts();
        list = s.bucketSort(list);
        assertEquals(Arrays.asList(1, 2, 3, 5, 7, 8, 9), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(8, 7, 6));
        Sorts s2 = new Sorts();
        list2 = s2.bucketSort(list2);
        assertEquals(Arrays.asList(6, 7, 8), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(4, 1, 1, 2));
        Sorts s3 = new Sorts();
        list3 = s3.bucketSort(list3);
        assertEquals(Arrays.asList(1, 1, 2, 4), list3);
    }

    @Test
    void countSort() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 7, 3, 9, 1, 8));
        Sorts s = new Sorts();
        list = s.countSort(list);
        assertEquals(Arrays.asList(1, 2, 3, 5, 7, 8, 9), list);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 6, 5));
        Sorts s2 = new Sorts();
        list2 = s2.countSort(list2);
        assertEquals(Arrays.asList(5, 6, 10), list2);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        Sorts s3 = new Sorts();
        list3 = s3.countSort(list3);
        assertEquals(Arrays.asList(1, 2, 3), list3);
    }
}