package algorithms.recursion;

/**
 * Created by tareqmy on 11/7/20.
 */
public class LearnRecursion {

    public static long fibonacciIterationArray(int position) {
        if (position < 2) {
            return position;
        }

        long[] fibArray = new long[position + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;
        for (int i = 2; i < (position + 1); i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }

        return fibArray[position];
    }

    //below and above are two alternate iterations with different space complexity
    public static long fibonacciIteration(long position) {
        if (position < 2) {
            return position;
        }

        long n1 = 0;
        long n2 = 1;
        long fibonacci = 1;

        for (int i = 2; i <= position; i++) {
            fibonacci = n1 + n2;
            n1 = n2;
            n2 = fibonacci;
        }

        return fibonacci;
    }

    //taken from the course
    //this is most concise yet has an exponential time complexity
    public static int fibonacciRecursively(int n) { //O(2^n)
        if (n < 2) {
            return n;
        }
        //also very confusing.
        return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
    }

    //--- recursive yet more like iterative

    public static long fibonacci(long position) {
        if (position < 2) {
            return position;
        }
        return fibonacci(position, 2, 0, 1); //O(n)
//        return fibonacciAlt(position, 0, 1); //O(n)
    }

    private static long fibonacci(long position, long current, long n1, long n2) {
        if (current >= position) {
            return n1 + n2;
        }
        return fibonacci(position, current + 1, n2, n1 + n2);
    }

    //note: above and below are actually same. one is counting up, the other is counting down
    private static long fibonacciAlt(long position, long n1, long n2) {
        if (position == 1) {
            return n2;
        }
        return fibonacciAlt(position - 1, n2, n1 + n2);
    }

    public static void main(String[] args) {

//        System.out.println("fibonacci = " + fibonacci(0));
//        System.out.println("fibonacci = " + fibonacci(1));
//        System.out.println("fibonacci = " + fibonacci(2));
        System.out.println("fibonacci = " + fibonacciIteration(3));
        System.out.println("fibonacci = " + fibonacciRecursively(4));
        System.out.println("fibonacci = " + fibonacciIterationArray(5));
        System.out.println("fibonacci = " + fibonacci(10));


//        System.out.println("factorial = " + factorial(0));
//        System.out.println("factorial = " + factorial(1));
        System.out.println("factorial = " + factorial(3));
        System.out.println("factorial = " + factorialIteration(4));
        //note: highest level of factorial that can be saved in 'int' is 31 and for 'long' 39


        System.out.println("reverseStringRecursive = " + reverseStringRecursive("12345678"));
    }

    public static long factorial(long number) { //O(n)
        if (number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static long factorialIteration(long number) { //O(n)
        if (number <= 1) {
            return 1;
        }

        long factorial = 1;
        while (number > 1) {
            factorial = factorial * number--;
        }
        return factorial;
    }

    //123456789
    public static String reverseStringRecursive(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        return reverseStringRecursive(input.substring(1)) + input.charAt(0);
    }

    public static String reverseString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) { //O(n)
            char buffer = chars[start];
            chars[start] = chars[end];
            chars[end] = buffer;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
