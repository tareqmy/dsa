package algorithms.sorting;

import java.util.Arrays;

/**
 * Created by tareqmy on 9/8/20.
 */
// Java program for implementation of Heap Sort
public class HeapSort {
    static void sort(int[] arr) {
        int n = arr.length;

        printArray(arr);
        // Build heap (rearrange array) -- start from the last non-leaf to root
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i); //heapify each non-leaf node until root

        printArray(arr);

        // One by one extract an element from heap
        //with each iteration the max element taken from heap and placed at the i position
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int leftChild = 2 * i + 1; // left = 2*i + 1
        int rightChild = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // If right child is larger than largest so far
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}

