package interview.amazon;

import interview.NodeWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 28/7/20.
 */
public class CopyListRandomPointer {

    public static NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {
        if (head == null) return null;

        Map<NodeWithRandomPointer, NodeWithRandomPointer> all = new HashMap<>();
        NodeWithRandomPointer current = head;
        NodeWithRandomPointer deepCopyHead = null;
        NodeWithRandomPointer currentCopy = null;

        while (current != null) {
            NodeWithRandomPointer newCopy = new NodeWithRandomPointer(current.val);
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
}
