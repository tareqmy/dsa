package interview;

/**
 * Created by tareqmy on 13/8/20.
 */

public class NodeWithRandomPointer {
    public int val;
    public NodeWithRandomPointer next;
    public NodeWithRandomPointer random;

    public NodeWithRandomPointer(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
