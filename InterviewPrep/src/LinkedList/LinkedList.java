package LinkedList;

public class LinkedList {
	
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	//create head node
	Node head;
	
	public void insertAtBeginning(int element) {
		if(head == null) {
			head = new Node(element);
			return;
		}
		Node new_node = new Node(element);
		new_node.next = head;
		head = new_node;
		return;
	}
	
	public void insertAtEnd(int element) {
		if(head == null) {
			head = new Node(element);
			return;
		}
		Node it = head;
		while(it.next!=null) {
			it = it.next;
		}
		Node new_node = new Node(element);
		it.next = new_node;
		return;
	}
	
	public void insertAfterNode(int element, int target) {
		Node it = head;
		while(it!=null && it.data != target) {
			it = it.next;
		}
		// if the target is not found
		if(it == null) { return; }
		Node new_node = new Node(element);
		new_node.next = it.next;
		it.next = new_node;
		return;
		
	}
	
	public boolean search(int target) {
		
		Node it = head;
		while(it!=null && it.data !=target) {
			it = it.next;
		}
		// if the target is not found
		if(it == null) { return false; }
		return true;
	}
	
	public void delete(int target) {
		Node it = head;
		Node prev = null;
		// if the head node matches target node.
		if(it.data == target) {
			head = it.next;
			return;
		}
		while(it!=null && it.data !=target) {
			prev = it;
			it = it.next;
		}
		// if the target is not found
		if(it == null) { return; }
		prev.next = it.next;
		return;
	}
	
	public void printList() {
		Node it = head;
		System.out.println("Printing the list...");
		while(it!=null) {
			System.out.print(it.data);
			System.out.print("-->");
			it = it.next;
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		list.insertAtEnd(5);
		list.insertAtBeginning(3);
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(4);
		list.insertAfterNode(2, 2);
		//print list
		list.printList();

		//delete
		list.delete(2);
		
		//print list
		list.printList();
		
		//search element in the list
		System.out.println("Searching if 3 is present in the list: " + list.search(3));
		System.out.println("Searching if 3 is present in the list: " + list.search(9));
	}

}
