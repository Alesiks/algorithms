package by.bsu.mmf.algo.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    // solution O(n^2)
    public int getSize1(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int[] increasingCountingArr = new int[arr.length];

        increasingCountingArr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int increasingCount = 0;
            int value = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (value > arr[j] && increasingCountingArr[j] > increasingCount) {
                    increasingCount = increasingCountingArr[j];
                }
            }
            increasingCountingArr[i] = Math.max(increasingCount + 1, 1);
        }

        return Arrays.stream(increasingCountingArr).max().getAsInt();
    }

    // solution O(n*log(n))
    public int getSize2(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        // the i value of array stores the last element of sequence with length i
        int[] lastSequenceElementsByLength = new int[arr.length + 1];
        Arrays.fill(lastSequenceElementsByLength, Integer.MAX_VALUE);
        lastSequenceElementsByLength[0] = Integer.MIN_VALUE;

        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            int value = arr[i];
            int index = getIndexWithBinarySearch(lastSequenceElementsByLength, value, 0, j);
            lastSequenceElementsByLength[index] = value;
        }

        return (int) (Arrays.stream(lastSequenceElementsByLength).filter(v -> v != Integer.MAX_VALUE).count() - 1);
    }

    private int getIndexWithBinarySearch(int arr[], int value, int startIndex, int lastIndex) {
        while (startIndex <= lastIndex) {
            int midIndex = (startIndex + lastIndex) / 2;
            if (value > arr[midIndex] && value < arr[midIndex + 1]) {
                return midIndex + 1;
            } else if(value >= arr[midIndex] && value < arr[midIndex + 1]) {
                return midIndex;
            } else if (value > arr[midIndex] && value >= arr[midIndex + 1]) {
                startIndex = midIndex + 1;
            } else { //if(value < midIndex) {
                lastIndex = midIndex - 1;
            }
        }

        throw new RuntimeException("something go wrong");
    }

}
