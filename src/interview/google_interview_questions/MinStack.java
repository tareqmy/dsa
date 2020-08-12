package interview.google_interview_questions;

/**
 * Created by tareqmy on 24/7/20.
 */
public class MinStack {

    //taken solution from leetcode discuss
    //keep only the top of the stack with linkedlist.
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
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

    //each node will keep the min when it was the head
    private static class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
