package interview.facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by tareqmy on 12/8/20.
 */
public class MergeIntervals {

    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]); //sort based on the first element of the arrays.
        }
    }

    //NOTE: could not solve... dont know whether writing on paper would have helped

    public static int[][] merge(int[][] intervals) { //O(nlogn)
        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
            System.out.println("merged = " + Arrays.toString(merged.getLast()));
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println("----");
        int[][] merged = merge(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

