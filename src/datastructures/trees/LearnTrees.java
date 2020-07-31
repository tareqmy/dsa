package datastructures.trees;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tareqmy on 8/7/20.
 */
public class LearnTrees {

    public static void main(String[] args) {
        //A Red-Black tree based {@link NavigableMap} implementation
        //NavigableMap > SortedMap > Map
        Map<String, String> treeMap = new TreeMap();

        /**
         *  * <p>This implementation provides guaranteed log(n) time cost for the
         *  * {@code containsKey}, {@code get}, {@code put} and {@code remove}
         *  * operations.  Algorithms are adaptations of those in Cormen, Leiserson, and
         *  * Rivest's <em>Introduction to Algorithms</em>.
         */

        treeMap.put("apple", "Apple"); //O(logn)
        treeMap.put("banana", "Banana"); //O(logn)
        treeMap.put("orange", "Orange"); //O(logn)

        treeMap.remove("banana"); //O(logn)

        treeMap.get("apple"); //O(logn)

        treeMap.containsKey("orange"); //O(logn)
    }
}
