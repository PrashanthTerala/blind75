public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        ListNode next3 = new ListNode(4);
        ListNode next4 = new ListNode(5);
        ListNode tail = new ListNode(6);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = tail;
        reorderList(head);
        printList(head);
    }

    private static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse second half
//        ListNode secondHalf = reverseLinkedList(slow.next);
        ListNode secondHalf = null, current = slow.next;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = secondHalf;
            secondHalf = current;
            current = tempNode;
        }
        slow.next = null; // Break the list into two halves

        // merge two lists
        ListNode firstHalf = head;
//        mergeTwoLinkedLists(firstHalf, secondHalf);
        while (firstHalf != null && secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf; // point fistHalf node to secondHalf
            if (temp1 == null) break;
            secondHalf.next = temp1;  // point secondHalf node to firstHalf
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        return previous;
    }

    private static void mergeTwoLinkedLists(ListNode list1, ListNode list2) {
//        list1: 1 -> 6 -> 2
//        list2: 6 -> 2

        while (list1 != null && list2 != null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            if (temp1 == null) break;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
