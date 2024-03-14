package linkedList;

/**
 * Problem: 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Solution:
 * 1->2->3->4->x
 * 4 => 4 => 1->2->3-><-4
 * 3->4 => x<-3<-4 => 1->2->3<-4
 */

public class ReverseLinkedList {

    public ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rev = recursiveReverseList(head.next);
        if (rev != null) {
            ListNode next = head.next;
            next.next = head;
            head.next = null;
        }
        return rev;
    }
}
