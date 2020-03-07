package by.bsu.mmf.algo.sort;

import java.util.Comparator;

/**
 * Created by Ales on 28.06.17.
 */
public class SelectionSort implements Sort {

    @Override
    public <T> void sort(T[] arrayToSort, Comparator<T> comparator) {
        for (int i = 0; i < arrayToSort.length; i++) {
            T tempMinElement = arrayToSort[i];
            int tempMinElementIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if(comparator.compare(arrayToSort[j], tempMinElement) < 0) {
                    tempMinElement = arrayToSort[j];
                    tempMinElementIndex = j;
                }
            }
            swapElements(arrayToSort, i, tempMinElementIndex);
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            T tempMinElement = arrayToSort[i];
            int tempMinElementIndex = i;
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if(arrayToSort[j].compareTo(tempMinElement) < 0) {
                    tempMinElement = arrayToSort[j];
                    tempMinElementIndex = j;
                }
            }
            swapElements(arrayToSort, i, tempMinElementIndex);
        }
    }

    private <T> void swapElements(T[] array, int i, int j) {
        T tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }
}
