package by.bsu.mmf.springexamples.sort;

import java.util.Comparator;

/**
 * Created by Ales on 01.07.17.
 */
public class QuickSort implements Sort {

    @Override
    public <T> T[] sort(T[] arrayToSort, Comparator<T> comparator) {
        return null;
    }

    @Override
    public <T extends Comparable> T[] sort(T[] arrayToSort) {
        return quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private <T extends Comparable> T[] quickSort(T[] arrayToSort, int firstElementIndex, int lastElementIndex) {
        if (firstElementIndex < lastElementIndex) {
            int separateElementIndex = findSeparatingElement(arrayToSort, firstElementIndex, lastElementIndex);
            quickSort(arrayToSort, firstElementIndex, separateElementIndex);
            quickSort(arrayToSort, separateElementIndex + 1, lastElementIndex);
        }
        return arrayToSort;
    }

    private <T extends Comparable> int findSeparatingElement(T[] arrayToSort, int firstElementIndex, int lastElementIndex) {
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
                i++;
            }
        }
        return i;
    }

    private <T extends Comparable> void swapElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
