package datastructures.arrays;

import java.util.*;

/**
 * Created by tareqmy on 5/7/20.
 */
public class LearnArrays {

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(complements.containsKey(nums[i])) {
                indices[0] = complements.get(nums[i]);
                indices[1] = i;
                break;
            }
            complements.put(complement, i);
        }

        return indices;
    }

    public static void main(String[] args) {
//        arrayFunction();
//        arrayList();
        int[] nums = {2, 7, 11, 15};
        Arrays.stream(twoSum(nums, 9)).forEach(value -> {
            System.out.println("value = " + value);
        });
    }

    public static void arrayFunction() {
        String[] strings = {"a", "b", "c", "d"};
        System.out.println(strings[2]);
        Arrays.binarySearch(strings, "a");
        Arrays.sort(strings);
    }

    public static void arrayList() {
        //ArrayList is random access
        //List is an ordered collection. order does not mean sorted. order means the position of increasing index.
        //an array cant have an invalid entry in the middle???

        List<String> fixedstringList = Arrays.asList("a", "b", "c", "d"); //Returns a fixed-size list backed by the specified array.

        List<String> stringList = new ArrayList<>();//Resizable-array implementation of the List interface.
        stringList.addAll(fixedstringList);//O(1) --- because it adds at the end
        stringList.add("i");//O(1) --- because it adds at the end
        stringList.add(0, "j");//O(n) --- because it adds at the start --- equivalent to unshift
        stringList.get(0);//O(1)
        System.out.println(stringList);
        stringList.set(0, "k");//O(1)?? ---- it replaces the item ... fails if outofbound
        System.out.println(stringList);
        stringList.contains("c");//O(n)
        stringList.remove(0);//O(n)? .... because shifts elements of the right to left one place

        System.out.println(stringList);
    }
}
