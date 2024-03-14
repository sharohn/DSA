package linkedList;

/**
 * ReverseNodesInKGroup
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode start = head, end = head;
        for (int i=1; i<k; i++) {
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        if (end == null) {
            return head;
        }
        ListNode revk = reverseKGroup(end.next, k);
        ListNode rev = reverseList(start, end.next);
        start.next = revk;
        return rev;
    }

    public ListNode reverseList(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}