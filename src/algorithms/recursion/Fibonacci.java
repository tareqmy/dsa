package algorithms.recursion;

public class Fibonacci {
    // Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8

    public static int calculations = 0;

    public static int fibonacciRecursively(int n) { //O(2^n)
        if (n < 2) {
            return n;
        }

        int fib = fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
        calculations++;
        return fib;
    }

    //----

    public static int fibonacciRecursivelyDynamic(int n) {
        Integer[] fibonacci = new Integer[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        return fibonacciRecursivelyDynamic(n, fibonacci);
    }

    private static int fibonacciRecursivelyDynamic(int n, Integer[] fibonacci) { //O(n)
        if (fibonacci[n] != null) {
            return fibonacci[n];
        }

        fibonacci[n] = fibonacciRecursivelyDynamic(n - 1, fibonacci) + fibonacciRecursivelyDynamic(n - 2, fibonacci);
        calculations++;
        return fibonacci[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacciIteratively(10));
        System.out.println(fibonacciRecursively(30) + " >>> calculations = " + calculations);
        calculations = 0;
        System.out.println(fibonacciRecursivelyDynamic(30) + " >>> calculations = " + calculations);
        calculations = 0;
        System.out.println(fibonacciDynamic(40) + " >>> calculations = " + calculations);
    }

    //----

    public static int fibonacciIteratively(int n) { //O(n)
        if (n < 2) {
            return n;
        }
        int result = 1;
        int lastNumber = 0;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = result;
            result += lastNumber;
            lastNumber = temp;
        }
        return result;
    }

    //---

    public static int fibonacciDynamic(int n) { //O(n)
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            calculations++;
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }
}
