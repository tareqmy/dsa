package interview.leetcode;

/**
 * Created by tareqmy on 26/7/20.
 */
public class BitMagic {

    public static void main(String[] args) {
        //        int integer = Integer.MAX_VALUE;
//        int integer = Integer.MIN_VALUE;
//        int integer = -1;
//        int integer = -2;
//        String toBinaryString = Integer.toBinaryString(integer);
//        System.out.println("int= " + integer);
//        System.out.println("toBinaryString = " + toBinaryString);

        System.out.println("Integer = " + Integer.parseInt("00000010100101000001111010011100", 2)); //43261596
        System.out.println("Integer = " + Integer.parseInt("00000000111001011110000010100101", 2)); //15065253 --- my result!
        System.out.println("Integer = " + Integer.parseInt("00111001011110000010100101000000", 2)); //964176192

        //NOTE: following operation fails!
//        System.out.println("Integer = " + Integer.parseInt("11111111111111111111111111111101", 2)); //43261596 for unsigned... -3 for signed

        System.out.println("Integer = " + Integer.parseUnsignedInt("11111111111111111111111111111101", 2)); //-3



        System.out.println( 4 + " << 1 = " + (4 << 1));
        System.out.println( 4 + " >> 1 = " + (4 >> 1));
        System.out.println( 4 + " >>> 1 = " + (4 >>> 1));
        System.out.println( 4 + " >>> 1 = " + (-4 >>> 1));
        System.out.println( 4 + " & 1 = " + (6 & 1));

        System.out.println("abs = " + Math.abs(Integer.MIN_VALUE + 1));
        System.out.println("abs = " + Math.abs(-1));
    }
}
