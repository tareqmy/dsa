package interview.leetcode;

import interview.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tareqmy on 25/7/20.
 */
public class IntersectionLinkedList {

    //Write a program to find the node at which the intersection of two singly linked lists begins.

    //O(m+n)
    //space O(m) or O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currentA = headA;
        ListNode currentB = headB;
        Set<ListNode> visited = new HashSet<>();
        while (currentA != null && currentB != null) {
            if (visited.contains(currentA)) {
                return currentA;
            } else {
                visited.add(currentA);
                currentA = currentA.next;
            }
            if (visited.contains(currentB)) {
                return currentB;
            } else {
                visited.add(currentB);
                currentB = currentB.next;
            }
        }
        while (currentA != null) {
            if (visited.contains(currentA)) {
                return currentA;
            } else {
                visited.add(currentA);
                currentA = currentA.next;
            }
        }
        while (currentB != null) {
            if (visited.contains(currentB)) {
                return currentB;
            } else {
                visited.add(currentB);
                currentB = currentB.next;
            }
        }

        return null;
    }

    //O(m+n)
    //space O(1)
    //two pointer solution
    public static ListNode getIntersectionNodeLC(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        System.out.println(" <---------- ");
        print(pa, "pa");
        print(pb, "pb");
        System.out.println(" ----------> ");
        //NOTE: for non intersecting it will end when both reach end of linkedlist same time
        //for intersecting it will eventually reach the intersection at the same time.
        while (pa != pb) {
            if (pa != null) {
                pa = pa.next;
            } else {
                pa = headB;
            }

            if (pb != null) {
                pb = pb.next;
            } else {
                pb = headA;
            }
            System.out.println(" <---------- ");
            print(pa, "pa");
            print(pb, "pb");
            System.out.println(" ----------> ");
        }

        return pa;
    }

    private static void print(ListNode c, String name) {
        if (c != null)
            System.out.println(name + " = " + c.val);
        else
            System.out.println(name + " = " + null);
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(12, new ListNode(14));
        ListNode a = new ListNode(2, new ListNode(4, x));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(5, x)));


        ListNode c = getIntersectionNodeLC(a, b);
        print(c, "c");
    }
}
