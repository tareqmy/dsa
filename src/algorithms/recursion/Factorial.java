package algorithms.recursion;

public class Factorial {
    // Write two functions that finds the factorial of any number.
    // One should use recursive, the other should just use a for loop

    public static long factorialRecursively(long number) { // O(n)
        if (number == 1) {
            return 1;
        }
        return number * factorialRecursively(number - 1);
    }

    public static long factorialIteratively(long number) { // O(n)
        long result = 1;
        for (long i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursively(10));
        System.out.println(factorialIteratively(25));

        System.out.println("findMaxValueInt() = " + findMaxValueInt()); //12
        System.out.println("findMaxValueLong() = " + findMaxValueLong()); //20
    }

    public static int findMaxValueInt()
    {
        int res = 2;
        int fact = 2;
        while (true)
        {
//            System.out.println("fact = " + fact + " res = " + res);
            // when fact crosses its size,
            // it gives negative value
            if (fact > Integer.MAX_VALUE/res)
                break;
            res++;
            fact = fact * res;
        }
        return res;
    }

    public static int findMaxValueLong()
    {
        int res = 2;
        long fact = 2;
        while (true)
        {
//            System.out.println("fact = " + fact + " res = " + res);
            // when fact crosses its size,
            // it gives negative value
            if (fact > Long.MAX_VALUE/res)
                break;
            res++;
            fact = fact * res;
        }
        return res;
    }
}
