package interview.leetcode;

import interview.ListNode;

/**
 * Created by tareqmy on 21/7/20.
 */
public class DeleteNode {

    //    The linked list will have at least two elements.
//    All of the nodes' values will be unique.
//    The given node will not be the tail and it will always be a valid node of the linked list.
//    Do not return anything from your function.
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
