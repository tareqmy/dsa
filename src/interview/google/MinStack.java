package interview.google;

import interview.NodeWithMin;

/**
 * Created by tareqmy on 24/7/20.
 */
public class MinStack {

    //taken solution from leetcode discuss
    //keep only the top of the stack with linkedlist.
    private NodeWithMin head;

    public void push(int x) {
        if (head == null)
            head = new NodeWithMin(x, x);
        else
            head = new NodeWithMin(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
