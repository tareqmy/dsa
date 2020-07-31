package interview.leetcode;

/**
 * Created by tareqmy on 31/7/20.
 */
public class NumberOfStepsToZero {

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println("numberOfSteps() = " + numberOfSteps2(8));
    }

    //somehow it is not better than above??? because we are still going over exact O(n)
    public static int numberOfSteps2(int num) {
        int steps = 0;
        String x = Integer.toBinaryString(num);
        int position = 1;
        for (int i = x.length() - 1; i >= 0; i--, position++) {
            if (x.charAt(i) == '1') {
                if (steps == 0) {
                    steps = steps + position;
                } else {
                    steps += 2;
                }
            } else {
                if (steps != 0) {
                    steps++;
                }
            }
        }

        return steps;
    }
}
