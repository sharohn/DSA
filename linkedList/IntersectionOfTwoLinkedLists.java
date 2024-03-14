package linkedList;

/**
 * Problem: 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 * If the two linked lists have no intersection at all, return null.
 * 
 * Solution:
 * 1. Find length of both lists
 * 2. The difference b/w length give the no of nodes we need to skip
 * 3. Skip the nodes from larger list
 * 4. Start iterating both the lists
 * 5. If both the nodes mathches, then we have an intersection
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = length(headA);
        int lb = length(headB);
        ListNode temp = null;
        if (la < lb) {
            temp = headA;
            headA = headB;
            headB = temp;
        }
        for (int i=0; i<Math.abs(la-lb); i++) {
            headA = headA.next;
        }

        while (headA!= null && headB!=null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int length(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
    
}