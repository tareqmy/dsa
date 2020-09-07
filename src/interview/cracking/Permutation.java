package interview.cracking;

/**
 * Created by tareqmy on 27/8/20.
 */
public class Permutation {

    public static void main(String[] args) {
        permutation("tareq");
    }

    public static void permutation(String str) {
        permutation(str, "");
    }

    public static void permutation(String str, String prefix) {
//        System.out.println("str = " + str + ",prefix = " + prefix);
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    //note: for 1,2,3,4 without repeat. permutation is 4*3*2*1 = 4! = 24
    //note: for 1,2,3,4 with    repeat. permutation is 4*4*4*4 = 4^4 = 256


    //in combination allowing 0-9. for a 4 digit combination
    //10 * 9 * 8 * 7 --- this still permutation
    //divide it by 4! --- (10*9*8*7)/4! = 5040/24 = 210
    //in combination --- 1234 = 4321?
}
