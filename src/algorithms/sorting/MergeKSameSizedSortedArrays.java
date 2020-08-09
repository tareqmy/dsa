package algorithms.sorting;

import java.util.Arrays;

/**
 * Created by tareqmy on 9/8/20.
 */
public class MergeKSameSizedSortedArrays {

    // Merge arr1[0..n1-1] and arr2[0..n2-1] into
    // arr3[0..n1+n2-1]
    static void mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Traverse both array
        while (i < n1 && j < n2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];

        System.out.println("---");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println("---");
    }

    // This function takes an array of arrays as an argument and
    // All arrays are assumed to be sorted. It merges them together
    // and prints the final sorted output.
    static void mergeKArrays(int[][] arr, int n, int i, int j, int[] output) {

        System.out.println("Enter " + i + ", " + j + ", " + n);

        //if one array is in range
        if (i == j) {
            if (n >= 0) System.arraycopy(arr[i], 0, output, 0, n);
            System.out.println("Returning single array >");
            System.out.println(Arrays.toString(output));
            System.out.println("Exit " + i + ", " + j + ", " + n);
            return;
        }

        //if only two arrays are left them merge them
        if (j - i == 1) {
            mergeArrays(arr[i], arr[j], output);
            System.out.println("Exit " + i + ", " + j + ", " + n);
            return;
        }

        //output arrays
        int[] out1 = new int[n * (((i + j) / 2) - i + 1)];
        int[] out2 = new int[n * (j - ((i + j) / 2))];

        //divide the array into halves
        mergeKArrays(arr, n, i, (i + j) / 2, out1);
        mergeKArrays(arr, n, (i + j) / 2 + 1, j, out2);

        //merge the output array
        mergeArrays(out1, out2, output);

        System.out.println("Exit " + i + ", " + j + ", " + n);
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    //NOTE: merged same size arrays
    public static void main(String[] args) {
        // Change n at the top to change number of elements
        // in an array

        int[][] arr = {{2, 6, 12, 34, 48},
                {1, 9, 20, 50, 1000},
                {3, 45, 65, 70, 100},
                {23, 34, 90, 100, 2000}};
        int k = arr.length;
        int n = arr[0].length;
        int[] output = new int[n * k];

        mergeKArrays(arr, n, 0, k - 1, output);

        System.out.println("Merged array -->");
        printArray(output);

    }

}







