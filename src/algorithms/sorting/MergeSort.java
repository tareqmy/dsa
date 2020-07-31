package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    private static void merge(int[] array, int p, int q, int r) {
        System.out.print("before merge > ");
        printArray(array, p, r);
        // Find sizes of two subarrays to be merged
        int n1 = q - p + 1;
        int n2 = r - q;

        /* Create temp arrays */
        int[] left = new int[n1];
        int[] right = new int[n2];

        /*Copy data to temp arrays*/
        if (n1 >= 0) System.arraycopy(array, p, left, 0, n1);
        if (n2 >= 0) System.arraycopy(array, q + 1, right, 0, n2);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray of array
        int k = p;
        //in this loop enter while both array has elements remaining.
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        //NOTE: either left or right array will have elements remaining... both wont be true at the same time
        //in original algorithm the left and right has a infinity on the topmost index...
        //to compensate that, as infinity is unattainable, this change was required

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }

        System.out.print("after merge > ");
        printArray(array, p, r);
    }

    private static void mergeSort(int[] array, int p, int r) {
        System.out.print("mergeSort > ");
        printArray(array, p, r);
        if (p < r) {
            int floor = (p + r) / 2;

            mergeSort(array, p, floor);
            mergeSort(array, floor + 1, r);
            merge(array, p, floor, r);
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    static void printArray(int[] arr, int p, int r) {
        for (int i = p; i <= r; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45, 50, 0, 90, 30, 46};
        mergeSort(array);
        printArray(array);
    }

    //-------------------------------------

    //an memory expensive java implementation is below-----

    public static Integer[] mergeSort(Integer[] array) {
        return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
    }

    public static List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }
        // Split Array in into right and left
        List<Integer> left = array.subList(0, array.size() / 2);
        System.out.println("Splitting left: " + left);
        List<Integer> right = array.subList(array.size() / 2, array.size());
        System.out.println("Splitting Right: " + right);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) { //Keep merging until we done with one of the sides
            if (left.get(leftIndex) <= right.get(rightIndex)) { //Fixed: "<" to "<=", this what makes the merge sort "stable"
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        merged.addAll(left.subList(leftIndex, left.size())); //Merging all "leftovers" elements as is because we know they are sorted
        merged.addAll(right.subList(rightIndex, right.size())); //Same
        System.out.println("Merged: " + merged);
        return merged;
    }
}
