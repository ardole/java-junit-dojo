package fr.dojo.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArraySorterTest {

    private int[] in;
    private int[] sortExpected;

    private ArraySorter arraySorter;

    @Before
    public void initializeTab() {
        arraySorter = new ArraySorter();
        in = new int[]{1, 2, 0, 8, 3, 5, 9, 25, 14};
        sortExpected = new int[]{0, 1, 2, 3, 5, 8, 9, 14, 25};
    }

    @Test
    public void bubbleSort() {
        assertArrayEquals(arraySorter.bubbleSort(in), sortExpected);
    }

    @Test
    public void insertionSort() {
        assertArrayEquals(arraySorter.insertionSort(in), sortExpected);
    }

    @Test
    public void selectionSort() {
        assertArrayEquals(arraySorter.selectionSort(in), sortExpected);
    }

}