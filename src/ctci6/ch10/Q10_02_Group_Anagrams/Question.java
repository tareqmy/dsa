package ctci6.ch10.Q10_02_Group_Anagrams;

import ctci6.commons.AssortedMethods;

import java.util.Arrays;

public class Question {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethods.stringArrayToString(array));
        Arrays.sort(array, new AnagramComparator());
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}
