package by.bsu.mmf.algo.dynamic;


/**
 * We define subsequence as any subset of an array. We define a subarray as a contiguous subsequence in an array.
 * Given an array, find the maximum possible sum among all nonempty subarrays.
 */
public class MaxSubArraySum {

    public int get(int[] arr) {

        int maxSubArraySum = arr[0];
        int previousSubArraySum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // depends on previousSubArraySum > 0 or not
            int currSubArraySum = Math.max(previousSubArraySum + arr[i], arr[i]);

            maxSubArraySum = Math.max(maxSubArraySum, currSubArraySum);
            previousSubArraySum = currSubArraySum;
        }

        return maxSubArraySum;
    }

}
