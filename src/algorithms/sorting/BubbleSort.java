package algorithms.sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - (1 + i); j++) {
                // -1 because we are counting j with j+1
                // -i because after each iteration the topmost item will already by sorted.. not necessary though... it is still O(n^2)
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    //NOTE: may be the implementation is not currect.... for nearly sorted it should have been O(n)
    //1 point--- it should traverse from top to bottom while we are doing bottom to top
    public static void main(String[] args) {
        int[] array = {8, 1, 56, 4, 7, 1, 87, 0};
        int[] sorted = bubbleSort(array);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println("[" + i + "] -> " + sorted[i]);
        }
    }

}
