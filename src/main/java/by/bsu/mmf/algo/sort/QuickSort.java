package by.bsu.mmf.algo.sort;

import java.util.Comparator;

/**
 * Created by Ales on 01.07.17.
 */
public class QuickSort implements Sort {

    @Override
    public <T> void sort(T[] arrayToSort, Comparator<T> comparator) {

    }

    @Override
    public <T extends Comparable<T>> void sort(T[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private <T extends Comparable<T>> void quickSort(T[] arrayToSort, int firstElementIndex, int lastElementIndex) {
        if (firstElementIndex < lastElementIndex) {
            int separateElementIndex = findSeparatingElement(arrayToSort, firstElementIndex, lastElementIndex);
            if (separateElementIndex - firstElementIndex > 0) {
                quickSort(arrayToSort, firstElementIndex, separateElementIndex-1);
            }
            if (lastElementIndex - (separateElementIndex + 1) > 0) {
                quickSort(arrayToSort, separateElementIndex + 1, lastElementIndex);
            }
        }
    }

    private <T extends Comparable<T>> int findSeparatingElement(T[] arrayToSort, int firstElementIndex, int lastElementIndex) {
        int basicElementIndex = (firstElementIndex + lastElementIndex) / 2;
        T basicElementValue = arrayToSort[basicElementIndex];

        int i = firstElementIndex;
        int j = lastElementIndex;
        while (i < j) {
            while (i <= lastElementIndex && arrayToSort[i].compareTo(basicElementValue) < 0) {
                i++;
            }
            while (j >= firstElementIndex && arrayToSort[j].compareTo(basicElementValue) > 0) {
                j--;
            }
            if (i < j && arrayToSort[i].compareTo(arrayToSort[j]) != 0) {
                swapElements(arrayToSort, i, j);
            } else if (arrayToSort[i].compareTo(arrayToSort[j]) == 0 && i != j) {
                i++;
            }
        }
        return i;
    }

    private <T extends Comparable<T>> void swapElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
