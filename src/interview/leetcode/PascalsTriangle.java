package interview.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tareqmy on 24/7/20.
 */
public class PascalsTriangle {

    //Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

    //In Pascal's triangle, each number is the sum of the two numbers directly above it.

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) return triangle;
        List<Integer> previous = new ArrayList<>(Collections.singletonList(1));
        triangle.add(previous);

        for (int i = 1; i < numRows; i++) {
            List<Integer> next = getNext(previous);
            triangle.add(next);
            previous = next;
        }

        return triangle;
    }

    public static List<Integer> getNext(List<Integer> previous) {
        List<Integer> next = new ArrayList<>();
        next.add(1);
        for (int i = 0; i < previous.size() - 1; i++) {
            next.add(previous.get(i) + previous.get(i + 1));
        }
        next.add(1);
        return next;
    }

    public static void main(String[] args) {
        System.out.println("generate(5) = " + generate(5));
    }
}
