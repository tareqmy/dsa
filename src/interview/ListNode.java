package interview;

/**
 * Created by tareqmy on 13/8/20.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(ListNode node) {
        System.out.print(node.val);
        while (node.next != null) {
            node = node.next;
            System.out.print(" > " + node.val);
        }
        System.out.println(" > null");
    }

    public void print() {
        System.out.print(val);
        if (next == null) {
            System.out.println(", next=null");
        } else {
            System.out.println(", next=" + next.val);
        }
    }
}
