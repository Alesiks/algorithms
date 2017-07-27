package by.bsu.mmf.algo.sort;

import java.util.Comparator;

/**
 * Created by Ales on 29.06.17.
 */
public class BubbleSort implements Sort {

    @Override
    public <T> void sort(T[] arrayToSort, Comparator<T> comparator) {
        sortRecursion(arrayToSort, comparator, arrayToSort.length-1);
    }

    @Override
    public <T extends Comparable> void sort(T[] arrayToSort) {
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
    }

    private <T> void sortRecursion(T[] arrayToSort, Comparator<T> comparator, int count) {
        boolean isSorted = true;
        for(int i = 0; i < count; i++) {
            if(comparator.compare(arrayToSort[i], arrayToSort[i+1]) > 0) {
                swapElements(arrayToSort, i, i + 1);
                isSorted = false;
            }
        }
        if(count > 1 && !isSorted) {
            sortRecursion(arrayToSort, comparator, count-1);
        }
    }

    private <T> void swapElements(T[] array, int i, int j) {
        T tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }

}
