class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2(int x) {
         val = x;
         next = null;
     }
}

public class DetectCycleInLinkedList {

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(3);
        ListNode2 next1 = new ListNode2(2);
        ListNode2 next2 = new ListNode2(0);
        ListNode2 tail = new ListNode2(-1);
        head.next = next1;
        next1.next = next2;
        next2.next = tail;
//        tail.next = next1;
        boolean nn = hasCycle(head);
        System.out.println(nn);
    }

    private static boolean hasCycle(ListNode2 head) {
        ListNode2 first = head;
        ListNode2 second = head;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if(first == second)
                return true;
        }
        return false;
    }
}
