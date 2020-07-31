package datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by tareqmy on 8/7/20.
 */
public class MyStack {

    private final Queue<String> queue = new ArrayDeque<>();

    public void push(String element) {
        if (queue.isEmpty()) {
            queue.offer(element);
        } else {
            Queue<String> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                temp.offer(queue.poll());
            }
            queue.offer(element);
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }
    }

    public String pop() {
        return queue.poll();
    }

    public String top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack queueUsingStack = new MyStack();
        queueUsingStack.push("tareq");
        System.out.println("queue = " + queueUsingStack.queue);
        queueUsingStack.push("sohel");
        System.out.println("queue = " + queueUsingStack.queue);
        queueUsingStack.push("amit");
        System.out.println("queue = " + queueUsingStack.queue);

        System.out.println("isEmpty = " + queueUsingStack.empty());
        System.out.println("top() = " + queueUsingStack.top());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("queue = " + queueUsingStack.queue);
        System.out.println("top() = " + queueUsingStack.top());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("queue = " + queueUsingStack.queue);
        System.out.println("top() = " + queueUsingStack.top());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("queue = " + queueUsingStack.queue);
        System.out.println("isEmpty = " + queueUsingStack.empty());
    }

}
