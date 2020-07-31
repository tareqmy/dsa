package datastructures.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static int[] MargeTwoSortedArray(int[] array1, int[] array2) {
        final int[] mergedArray = new int[array1.length + array2.length];
        int j = 0, k = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (j != array1.length && (k == array2.length || array1[j] < array2[k])) {
                mergedArray[i] = array1[j];
                j++;
            } else {
                mergedArray[i] = array2[k];
                k++;
            }
        }
        return mergedArray;
    }

    public static void main(String[] args) {
//        int[] arr = MargeTwoSortedArray(new int[]{1, 1, 8, 9, 10}, new int[]{1, 2, 8, 9, 11, 15, 16});
//        Arrays.stream(arr).forEach(System.out::println);


        int[] sort1 = {1, 2, 2, 3, 13, 15, 17};
        int[] sort2 = {2, 2, 2, 4, 6, 8, 9, 10, 11, 19, 20, 21};
//        int[] sort1 = {0, 3, 4, 31};
//        int[] sort2 = {4, 6, 30, 44, 66};
        System.out.println(Arrays.toString(sort1));
        System.out.println(Arrays.toString(sort2));
        int[] ints = mergeSortedArrays(sort1, sort2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] mergeSortedArrays(int[] input1, int[] input2) {
        int[] sorted = new int[input1.length + input2.length];

        int i = 0, j = 0, k = 0;
        while (i < input1.length) {

            //enter input2 until they are no longer larger than current input1
            while (j < input2.length) {
                if (input1[i] > input2[j]) {
                    sorted[k] = input2[j];
                    j++;
                    k++;
                } else {
                    break;
                }
            }

            sorted[k] = input1[i];
            i++;
            k++;
        }

        //enter rest of input2 because rest of them are larger than the last of input1
        while (j < input2.length) {
            sorted[k] = input2[j];
            j++;
            k++;
        }

        return sorted;
    }

    //        int[] sort1 = {1, 2, 2, 3, 13, 15, 17};
//        int[] sort2 = {2, 2, 2, 4, 6, 8, 9, 10, 11, 19, 20, 21};
//    int[] sort1 = {0, 3, 4, 31};
//    int[] sort2 = {4, 6, 30, 44, 66};
    public static int[] mergeSortedArrays2(int[] input1, int[] input2) {
        int[] sorted = new int[input1.length + input2.length];

        int i = 0, j = 0, k = 0;
        while (k < sorted.length) {

            if (j < input2.length) { //input2 available

                if (i >= input1.length) { //input1 not available
                    sorted[k] = input2[j];
                    j++;

                } else if (input1[i] > input2[j]) { //input1 and input2 available and input2 current is smaller
                    sorted[k] = input2[j];
                    j++;

                } else { //input1 and input2 available and input2 current is bigger
                    sorted[k] = input1[i];
                    i++;
                }

            } else { //no more input2 left
                sorted[k] = input1[i];
                i++;
            }

            k++;
        }

        return sorted;
    }
}
