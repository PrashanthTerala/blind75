public class DetectCycleInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode tail = new ListNode(-1);
        head.next = next1;
        next1.next = next2;
        next2.next = tail;
//        tail.next = next1;
        boolean nn = hasCycle(head);
        System.out.println(nn);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second)
                return true;
        }
        return false;
    }
}
