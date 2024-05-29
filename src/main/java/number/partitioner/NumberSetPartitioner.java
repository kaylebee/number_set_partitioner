package number.partitioner;

import java.util.*;
import java.util.concurrent.*;

/**
 * NumberSetPartitioner class partitions a set of numbers into K subsets with consecutive sums.
 */
public class NumberSetPartitioner
{
    /**
     * The main method that executes the program.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Integer[] nums = {10, 11, 7, 7, 12};
        int K = 2;
        List<List<Integer>> result = divide(nums, K);
        if (result != null) {
            System.out.println(divide(nums, K));
        } else {
            System.out.println("невозможно");
        }
    }

    /**
     * This method partitions a set of numbers into K subsets with consecutive sums.
     * @param nums The array of integers to be partitioned.
     * @param K The number of partitions to be made.
     * @return A list of integer lists, each representing a partition. Returns null if partitioning is not possible.
     */
    public static List<List<Integer>> divide(Integer[] nums, int K) {
        int sum = Arrays.stream(nums).mapToInt(Integer::intValue).sum();
        int L = (sum - K * (K - 1) / 2) / K;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>(Arrays.asList(nums));

        for (int i = 0; i < K; i++) {
            int target = L + i;
            Integer[] arr = new Integer[numsList.size()];
            arr = numsList.toArray(arr);
            List<Integer> part = null;
            for (int num : nums) {
                if (num == target) {
                    part = new ArrayList<>(Arrays.asList(num));
                    break;
                }
            }
            if (part == null) {
                part = findSum(arr, target, 0);
            }

            if (part == null) return null;

            for (Integer num : part) {
                numsList.remove(num);
            }
            res.add(part);
        }
        return res;
    }

    /**
     * This method finds a subset of the array that sums up to the target sum.
     * @param arr The array of integers in which to find the subset.
     * @param targetSum The target sum to be achieved by the subset.
     * @param startIndex The index from which to start looking for the subset in the array.
     * @return An ArrayList of integers representing the subset. Returns null if no such subset is found.
     */
    public static ArrayList<Integer> findSum(Integer[] arr, int targetSum, int startIndex) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }

        if (startIndex >= arr.length || targetSum < 0) {
            return null;
        }

        ArrayList<Integer> withFirstElement = findSum(arr, targetSum - arr[startIndex], startIndex + 1);
        if (withFirstElement != null) {
            withFirstElement.add(0, arr[startIndex]);
            return withFirstElement;
        }

        return findSum(arr, targetSum, startIndex + 1);
    }
}
