package by.bsu.mmf.springexamples.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Ales on 23.06.17.
 */
public class SortTest {

    private Sort insertionSort = new InsertionSort();

    private Sort selectionSort = new SelectionSort();

    private Sort bubbleSort = new BubbleSort();

    private Sort quickSort = new QuickSort();

    @Test
    public void insertionSortArrayLong_test() {
        Long[] arrayForSorting = {-200L, 1L, 3L, 59L, 5L, 65L, 43L, 21L, 0L, -1L, 0L};

        Long[] sortedArray = insertionSort.sort(arrayForSorting);
        List<Long> newList = Arrays.stream(sortedArray).collect(Collectors.toList());
        newList.forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void selectionSortArrayLong_test() {
        Long[] arrayForSorting = {-200L, 1L, 3L, 59L, 5L, 65L, 43L, 21L, 0L, -1L, 0L};

        Long[] sortedArray = selectionSort.sort(arrayForSorting);
        List<Long> newList = Arrays.stream(sortedArray).collect(Collectors.toList());
        newList.forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void bubbleSortArrayLong_test() {
        Long[] arrayForSorting = {-200L, 1L, 3L, 59L, 5L, 65L, 43L, 21L, 0L, -1L, 0L};

        Long[] sortedArray = bubbleSort.sort(arrayForSorting);
        List<Long> newList = Arrays.stream(sortedArray).collect(Collectors.toList());
        newList.forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void quickSortArrayLong_test() {
        Long[] arrayForSorting = {-200L, 1L, 3L, 59L, 5L, 65L, 43L, 21L, 0L, -1L, 0L};

        Long[] sortedArray = quickSort.sort(arrayForSorting);
        List<Long> newList = Arrays.stream(sortedArray).collect(Collectors.toList());
        newList.forEach(item -> System.out.print(item + " "));
    }

    @Test
    public void bubbleSortArrayString_test() {
        final int arrayLength = 10000;
        String[] strArrayForSorting = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            strArrayForSorting[i] = getRandomString();
        }

        String[] sortedArray = new String[10];
        for(int i = 0; i < 5; i++) {
            String[] arrayCopy = strArrayForSorting.clone();
            double startTime = System.nanoTime();
            sortedArray = bubbleSort.sort(arrayCopy);
            double endTime = System.nanoTime();
            System.out.println("try " + i + ", time : " + (endTime - startTime) / 1000000 + " ms");
        }
        List<String> newList = Arrays.stream(sortedArray).collect(Collectors.toList());
        newList.forEach(item -> System.out.println(item + " "));
    }

    private String getRandomString() {
        final int STR_LENGTH = 10;
        final String ALPHABET = "abcdefghijklmnqoprstuvwxyz";

        StringBuilder randomGeneratedStr = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < STR_LENGTH; i++) {
            int randomNum = (int) (rand.nextDouble() * ALPHABET.length());
            randomGeneratedStr.append(ALPHABET.substring(randomNum, randomNum + 1));
        }

        return randomGeneratedStr.toString();
    }

}
