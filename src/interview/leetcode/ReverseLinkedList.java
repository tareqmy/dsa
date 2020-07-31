package interview.leetcode;

/**
 * Created by tareqmy on 21/7/20.
 */
public class ReverseLinkedList {

//    Reverse a singly linked list.
//A linked list can be reversed either iteratively or recursively. Could you implement both?


    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        head.print();
        ListNode parent = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        head.print();
        return parent;
    }
    //NOTE: both copied from LEETCODE...
    //YOU NEED TO DRAW THE SEQUENCE ON PAPER TO COME CLOSE TO THE LOGIC
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head.print(head);
        ListNode listNode = reverseList(head);
        listNode.print(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void print(ListNode node) {
            System.out.print(node.val);
            while (node.next != null) {
                node = node.next;
                System.out.print(" > " + node.val);
            }
            System.out.println(" > null");
        }

        void print() {
            System.out.print(val);
            if(next == null) {
                System.out.println(", next=null");
            } else {
                System.out.println(", next=" +next.val);
            }
        }
    }

}
