package by.bsu.mmf.springexamples.sort;

import java.util.Comparator;

/**
 * Created by Ales on 29.06.17.
 */
public class BubbleSort implements Sort {

    @Override
    public <T> T[] sort(T[] arrayToSort, Comparator<T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < arrayToSort.length - 1; j++) {
                if (comparator.compare(arrayToSort[j], arrayToSort[j + 1]) > 0) {
                    swapElements(arrayToSort, j, j + 1);
                    isSorted = false;
                }
            }
        }
        return arrayToSort;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] arrayToSort) {
        boolean isSorted = false;
        int lastSwappedIndex = arrayToSort.length - 1;
        int firstIndex = 0;
        while (!isSorted) {
            isSorted = true;
            int tempLastSwappedIndex = lastSwappedIndex;
            int tempFirstIndex = firstIndex;
            for (int j = firstIndex; j < lastSwappedIndex; j++) {
                if (arrayToSort[j].compareTo(arrayToSort[j + 1]) > 0) {
                    swapElements(arrayToSort, j, j + 1);
                    isSorted = false;
                    tempLastSwappedIndex = j + 1;
                }
            }
            lastSwappedIndex = tempLastSwappedIndex;
            for (int j = lastSwappedIndex; j > firstIndex; j--) {
                if (arrayToSort[j - 1].compareTo(arrayToSort[j]) > 0) {
                    swapElements(arrayToSort, j, j - 1);
                    isSorted = false;
                    tempFirstIndex = j - 1;
                }
            }
            firstIndex = tempFirstIndex;
        }
        return arrayToSort;
    }

    private <T> void swapElements(T[] array, int i, int j) {
        T tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }

}
