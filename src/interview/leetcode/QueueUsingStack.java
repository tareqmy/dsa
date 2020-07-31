package interview.leetcode;

import java.util.Stack;

/**
 * Created by tareqmy on 19/7/20.
 */
public class QueueUsingStack {

    private final Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public QueueUsingStack() {
        this.stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (this.stack.isEmpty()) {
            this.stack.push(x);
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!this.stack.isEmpty()) {
                temp.push(this.stack.pop());
            }
            this.stack.push(x);
            while (!temp.isEmpty()) {
                this.stack.push(temp.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.push(1);
        queue.push(2);
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty(); // returns false
    }
}
