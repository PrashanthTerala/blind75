public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        list1.next = node2;
        node2.next = node3;

        ListNode list2 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        list2.next = node5;
        node5.next = node6;
        ListNode mergedNode = mergeTwoLists(list1, list2);
        while (mergedNode != null) {
            System.out.print(mergedNode.val + " -> ");
            mergedNode = mergedNode.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode();
        ListNode tailNode = headNode;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val){
                tailNode.next = list1;
                list1 = list1.next;
            } else {
                tailNode.next = list2;
                list2 = list2.next;
            }
            tailNode = tailNode.next;
        }
        while(list1 != null){
            tailNode.next = list1;
            tailNode = tailNode.next;
            list1 = list1.next;
        }
        while(list2 != null){
            tailNode.next = list2;
            tailNode = tailNode.next;
            list2 = list2.next;
        }
        return headNode.next;
    }

}
