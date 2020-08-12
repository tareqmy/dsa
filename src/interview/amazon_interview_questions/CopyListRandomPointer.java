package interview.amazon_interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 28/7/20.
 */
public class CopyListRandomPointer {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> all = new HashMap<>();
        Node current = head;
        Node deepCopyHead = null;
        Node currentCopy = null;

        while (current != null) {
            Node newCopy = new Node(current.val);
            all.put(current, newCopy);
            if (deepCopyHead == null) {
                deepCopyHead = newCopy;
                currentCopy = newCopy;
            } else {
                currentCopy.next = newCopy;
                currentCopy = currentCopy.next;
            }
            current = current.next;
        }

        current = head;
        currentCopy = deepCopyHead;
        while (current != null) {
            if (current.random != null) {
                currentCopy.random = all.get(current.random);
            }
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return deepCopyHead;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
