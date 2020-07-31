package datastructures.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 6/7/20.
 */
public class LearnHashTables {

    /*
     * generally hashtables has complexity of O(1) for all cases
     * until a hash collision occurs, when collision is resolved through linkedlist
     * and then complexity becomes O(n)
     */

    public static void main(String[] args) {
        hashFunctions();
    }

    public static void hashFunctions() {
        Map<String, String> map = new HashMap<>();

        map.put("apple", "Apple"); //O(1)
        map.put("orange", "Orange");
        map.put("banana", "Banana");

        map.get("apple"); //O(1) --- lookup... O(n) during collision
        map.remove("apple"); //O(1)

        map.containsKey("apple"); //O(1)
        map.containsValue("Apple"); //O(n)???
    }

}
