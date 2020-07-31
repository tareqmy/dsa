package datastructures.queues;

import java.util.Stack;

/**
 * Created by tareqmy on 8/7/20.
 */
public class MyQueue {

    private final Stack<String> stack = new Stack<>();

    public void push(String element) {
        if(stack.isEmpty()) {
            stack.push(element);
        } else {
            Stack<String> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            stack.push(element);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue queueUsingStack = new MyQueue();
        queueUsingStack.push("tareq");
        System.out.println("stack = " + queueUsingStack.stack);
        queueUsingStack.push("sohel");
        System.out.println("stack = " + queueUsingStack.stack);
        queueUsingStack.push("amit");
        System.out.println("stack = " + queueUsingStack.stack);

        System.out.println("isEmpty = " + queueUsingStack.isEmpty());
        System.out.println("peek() = " + queueUsingStack.peek());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("stack = " + queueUsingStack.stack);
        System.out.println("peek() = " + queueUsingStack.peek());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("stack = " + queueUsingStack.stack);
        System.out.println("peek() = " + queueUsingStack.peek());
        System.out.println("pop() = " + queueUsingStack.pop());
        System.out.println("stack = " + queueUsingStack.stack);
        System.out.println("isEmpty = " + queueUsingStack.isEmpty());
    }

}
