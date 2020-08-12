package interview.amazon_interview_questions;

/**
 * Created by tareqmy on 26/7/20.
 */
public class AddTwoNumbers {

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int n1 = getNumber(l1);
//        int n2 = getNumber(l2);
//        System.out.println("n1 = " + n1);
//        System.out.println("n2 = " + n2);
//        return getList(n1 + n2);
//    }
//
//    //todo: solution is add two digits and get carry and then add next two digits with carry.... for example ---
//              this solution failed for this input.
//              l1 = [9]
//              l2 = [1,9,9,9,9,9,9,9,9,9]
//      expected   = [0,0,0,0,0,0,0,0,0,0,1]
//
//    private static int getNumber(ListNode node) {
//        if (node == null) return 0;
//        int number = 0;
//        int power = 0;
//        while (node != null) {
//            //todo: what about max_integer?
//            number = number + (int) (node.val * Math.pow(10, power));
//            node = node.next;
//            power++;
//        }
//        return number;
//    }
//
//    private static ListNode getList(int n) {
//        if (n == 0) return new ListNode(0);
//        ListNode head = null;
//        ListNode currentNode = null;
//        while (n != 0) {
//            int rem = n % 10;
//            ListNode thisNode = new ListNode(rem);
//            if (head == null) {
//                currentNode = thisNode;
//                head = currentNode;
//            } else {
//                currentNode.next = thisNode;
//                currentNode = thisNode;
//            }
//            n = n / 10;
//        }
//
//        return head;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val;
            if (sum <= 9) {
                val = sum;
                carry = 0;
            } else {
                val = sum % 10;
                carry = 1;
            }
            ListNode thisNode = new ListNode(val);
            if (result == null) {
                currentNode = thisNode;
                result = currentNode;
            } else {
                currentNode.next = thisNode;
                currentNode = thisNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            int val;
            if (sum <= 9) {
                val = sum;
                carry = 0;
            } else {
                val = sum % 10;
                carry = 1;
            }
            ListNode thisNode = new ListNode(val);
            if (result == null) {
                currentNode = thisNode;
                result = currentNode;
            } else {
                currentNode.next = thisNode;
                currentNode = thisNode;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int val;
            if (sum <= 9) {
                val = sum;
                carry = 0;
            } else {
                val = sum % 10;
                carry = 1;
            }
            ListNode thisNode = new ListNode(val);
            if (result == null) {
                currentNode = thisNode;
                result = currentNode;
            } else {
                currentNode.next = thisNode;
                currentNode = thisNode;
            }
            l2 = l2.next;
        }

        if (carry != 0) {
            currentNode.next = new ListNode(carry);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode node1 = new ListNode(9);
//        ListNode node2 = new ListNode(1, new ListNode(9, new ListNode(9)));
        ListNode listNode = addTwoNumbers(node1, node2); //todo: currently failing when result is greater than MAX_INTEGER
//        System.out.println("getNumber() = " + getNumber(node1));
//        System.out.println("getNumber() = " + getNumber(node2));
//        ListNode listNode = getList(1000);
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
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
}
