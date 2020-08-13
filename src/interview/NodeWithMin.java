package interview;

/**
 * Created by tareqmy on 13/8/20.
 */
//each node will keep the min when it was the head
public class NodeWithMin {
    public int val;
    public int min;
    public NodeWithMin next;

    public NodeWithMin(int val, int min) {
        this(val, min, null);
    }

    public NodeWithMin(int val, int min, NodeWithMin next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
