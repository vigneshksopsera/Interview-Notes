package LinkedList;

import LinkedList.LinkedList.Node;

public class PalindromeLinkedList {
	public boolean isPalindrome(Node head) {
        if(head == null) return true;
        Node dummy = new Node(0), l2= new Node(0);
        Node l1 = dummy;
        Node start = dummy;
        start.next = head;
        
        //get the lenght of list
        int lenOfList = -1;
        while(start!=null) {
            start = start.next;
            lenOfList++;
        }
        
        boolean isEven = (lenOfList%2) == 0? true : false;
        int halfLen = lenOfList/2;
        
        for(int i=0; i<halfLen; i++) {
            l1 = l1.next;
        }
        // make seperate list for l2
        l2.next = isEven ? l1.next : l1.next.next;
        // break the input list into l1 and l2. Middle node in odd doesnt matter.
        //ex 1-2-3-2-1  if 1-2 equals 2-1(reverse it), it is palindrome..3 node doesnt mater
        l1.next = null; 
        l1 = dummy;
        
        //reverse the node
        l2.next = reverseList(l2.next);
        
        //iterate halfLen steps for both l1 and l2 and check if values are equal
        l1 = l1.next; l2 = l2.next;
        while(halfLen !=0) {
            if(l1.data != l2.data) return false;
            l1 = l1.next;
            l2 = l2.next;
            halfLen--;
        }
        return true;
    }
    
    public Node reverseList(Node head) {
        /* iterative solution */
        Node newHead = null;
        while (head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
