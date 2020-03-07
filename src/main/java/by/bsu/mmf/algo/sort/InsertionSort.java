package by.bsu.mmf.algo.sort;

import java.util.Comparator;

/**
 * Created by Ales on 23.06.17.
 */
public class InsertionSort implements Sort {

    @Override
    public <T> void sort(T[] arrayToSort, Comparator<T> comparator) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arrayToSort[i], arrayToSort[j]) < 0) {
                    moveItems(arrayToSort, i, j);
                }
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arrayToSort[i].compareTo(arrayToSort[j]) < 0) {
                    moveItems(arrayToSort, i, j);
                }
            }
        }
    }

    private <T> void moveItems(T[] arrayToSort, int i, int j) {
        T movedValue = arrayToSort[i];
        for (int k = i; k > j; k--) {
            arrayToSort[k] = arrayToSort[k - 1];
        }
        arrayToSort[j] = movedValue;
    }
}
