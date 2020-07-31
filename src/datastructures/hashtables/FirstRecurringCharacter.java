package datastructures.hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static Object getFirstRecurringObject(Object[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i].equals(inputArray[j])) {
                    return inputArray[i];
                }
            }
        }
        return null;
    }

    public static Object getFirstRecurringObjectBetter(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>();
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            } else {
                map.add(obj);
            }
        }
        return null;
    }

    public static Object getFirstRecurringObjectBetter2(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray)); //Filling the hash table before checking if the item exist
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        Object[] arr = {1, 5, 8, 5, 1, 8, 8, 7, 4, 4, 10};
//        System.out.println(getFirstRecurringObjectBetter(arr));
//        System.out.println(getFirstRecurringObjectBetter2(arr));
//        System.out.println(getFirstRecurringObject(arr));
//        int[] array = {2, 5, 1, 2, 6,2,7,9,22};
//        int[] array = {2, 1, 1, 2, 3, 5, 87, 23,6};
        int[] array = {1, 3, 6, 8, 5};
        System.out.println(getFirstRecurringFromNonZeroIntegers(array));
    }

    public static int getFirstRecurringFromNonZeroIntegers(int[] input) {

        Set<Integer> visited = new HashSet<>();

        for (int value : input) { //O(n)
            if (visited.contains(value)) {
                return value;
            }
            visited.add(value);
        }
        return 0;
    }
}
