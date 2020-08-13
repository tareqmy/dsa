package interview.leetcode;

import interview.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tareqmy on 21/7/20.
 */
public class PalindromeLinkedList {

    //Palindrome -- a word, phrase, or sequence that reads the same backwards as forwards

    //Given a singly linked list, determine if it is a palindrome.

    //Could you do it in O(n) time and O(1) space?

    public boolean isPalindrome(ListNode head) {

        Deque<Integer> deque = new LinkedList<>();
        ListNode currentNode = head;

        while (currentNode != null) {
            deque.offer(currentNode.val);
            currentNode = currentNode.next;
        }

        while (deque.size() > 1) {
            Integer first = deque.pollFirst();
            Integer last = deque.pollLast();
            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }
}
