package Recursion;

/**
 * 
 * Q - https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
 * 
 * Tags - Linkedlists, Recursion
 * @author vignesh
 *
 */
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
public class swapNodeInPairs {
	public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

	//Iterative solution
//	public ListNode swapPairs(ListNode head) {
//	    ListNode dummy = new ListNode(0);
//	    dummy.next = head;
//	    ListNode current = dummy;
//	    while (current.next != null && current.next.next != null) {
//	        ListNode first = current.next;
//	        ListNode second = current.next.next;
//	        first.next = second.next;
//	        current.next = second;
//	        current.next.next = first;
//	        current = current.next.next;
//	    }
//	    return dummy.next;
//	}
}
