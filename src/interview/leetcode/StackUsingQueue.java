package interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tareqmy on 19/7/20.
 */
public class StackUsingQueue {

    private final Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public StackUsingQueue() {
        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            Queue<Integer> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                temp.offer(queue.poll());
            }
            queue.offer(x);
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }
}
