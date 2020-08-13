package algorithms.sorting;

import interview.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tareqmy on 9/8/20.
 */
public class MergeKVariableSizedSortedLinkedLists {

    //NOTE: although used linkedlist here... can be migrated to arrays.
    //256 ms, faster than 8.57%
    public ListNode mergeKLists(ListNode[] lists) { //O(kN) where k is the number of linked lists.
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int minIndex = getMinIndex(lists);
        while (minIndex >= 0) {
            tail.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            tail = tail.next;
            minIndex = getMinIndex(lists);
        }

        return dummy.next;
    }

    private int getMinIndex(ListNode[] lists) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val < minValue) {
                minIndex = i;
                minValue = lists[minIndex].val;
            }
        }
        return minIndex;
    }

    //6 ms, faster than 53.05%
    public ListNode mergeKListsOptimized(ListNode[] lists) { //O(nlogk)
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
