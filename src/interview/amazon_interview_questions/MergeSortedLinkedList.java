package interview.amazon_interview_questions;

/**
 * Created by tareqmy on 22/7/20.
 */
public class MergeSortedLinkedList {

    //    Merge two sorted linked lists and return it as a new sorted list.
    //    The new list should be made by splicing together the nodes of the first two lists.
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode merged = null;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        if (l1.val > l2.val) {
            merged = l2;
            currentL2 = l2.next;
        } else {
            merged = l1;
            currentL1 = l1.next;
        }
        ListNode currentMerged = merged;

        while (currentL1 != null && currentL2 != null) {
            if (currentL1.val > currentL2.val) {
                currentMerged.next = currentL2;
                currentL2 = currentL2.next;
                currentMerged = currentMerged.next;
            } else {
                currentMerged.next = currentL1;
                currentL1 = currentL1.next;
                currentMerged = currentMerged.next;
            }
        }

        while (currentL1 != null) {
            currentMerged.next = currentL1;
            currentL1 = currentL1.next;
            currentMerged = currentMerged.next;
        }

        while (currentL2 != null) {
            currentMerged.next = currentL2;
            currentL2 = currentL2.next;
            currentMerged = currentMerged.next;
        }

        return merged;
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
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoListsR(l1, l2);
        ListNode traverse = listNode;
        while (traverse != null) {
            System.out.print(traverse.val + " > ");
            traverse = traverse.next;
        }
    }

    //Solution with recursion! copied from leetcode
    public static ListNode mergeTwoListsR(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoListsR(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsR(l1, l2.next);
            return l2;
        }
    }
}
