package interview.leetcode;

/**
 * Created by tareqmy on 19/7/20.
 */
public class SumIntWithoutPlus {

    //Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }

    //in first iteration adding is done and if carry bit exists in the lowest level iteratively add the carry bit... until there is no carry bit
    public static int getSumIterative(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0)  {
            System.out.println(" >>> a = " + a + ", b = " + b);
            System.out.println(" >>> binary(a) = " + Integer.toBinaryString(a) + ", binary(b) = " + Integer.toBinaryString(b));
            int carry = (a & b); //splitting into two action causes wrong result
            System.out.println("carry = " + Integer.toBinaryString(carry));
            carry = carry << 1;
            System.out.println("carry = " + Integer.toBinaryString(carry));
            a = a ^ b;
            b = carry; // reassign the carry into b
            System.out.println("-------");
        }
        System.out.println("after >>> a = " + Integer.toBinaryString(a) + ", b = " + Integer.toBinaryString(b));
        return a;
    }

    public static void main(String[] args) {
//        System.out.println("sum = " + getSum(3, 5));
        System.out.println("sum = " + getSumIterative(7, 2));

//        int a = 3; int b = 5; int c = 0;
//        System.out.println("a = " + a + ", binary(a) = " + Integer.toBinaryString(a));
//        System.out.println("b = " + b + ", binary(b) = " + Integer.toBinaryString(b));
//        System.out.println("---");
//        c = a << 1; //LEFT SHIFT
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        c = a >> 1; //RIGHT SHIFT
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        c = a >>> 1; //UNSIGNED RIGHT SHIFT
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        System.out.println("---");
//        c = a | b; //OR
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        c = a & b; //AND
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        c = a ^ b; //XOR
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
//        System.out.println("---");
//        c = ~a; //NOT or 2's Complement
//        System.out.println("c = " + c + ", binary(c) = " + Integer.toBinaryString(c));
    }

}
