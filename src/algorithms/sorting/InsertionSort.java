package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {1, 8, 54, 9, 65, 1, 100, 0, 45};
        int[] sorted = insertionSort(array);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] insertionSort(int[] input) {
        for (int i = 1; i < input.length; ++i) {
            int key = input[i];
            //find the place of key in the left side of the array which is sorted. and right shift elements that are larger than key
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
            }
            input[j + 1] = key;
        }
        return input;
    }
}
