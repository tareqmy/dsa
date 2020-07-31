package algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {5, 1, 85, 4, 7, 9, 0, 3, 1};
        int[] sorted = selectionSort(array);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println("[" + i + "] -> " + sorted[i]);
        }
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //find the index of the minimum value and replace it with value of index i
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int buffer = array[i];
            array[i] = array[minIndex];
            array[minIndex] = buffer;
        }
        return array;
    }

}
