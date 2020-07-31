package datastructures.linkedlists;

import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tareqmy on 7/7/20.
 */
public class LearnLinkedLists {

    public static void main(String[] args) {
        linkedLists();
    }

    public static void linkedLists() {
        LinkedList<String> fruitList = new LinkedList<>();

        fruitList.push("apples");//O(1)
        fruitList.push("grapes");//O(1)
        fruitList.push("pears");//O(1)
        fruitList.add(1, "banana");//O(n)
        fruitList.pop();//O(1)
        fruitList.remove(1);//O(n)

        fruitList.get(1);//O(n) --- because of the traversal needed to get there.
        fruitList.contains("apples");//O(n)
    }
}
