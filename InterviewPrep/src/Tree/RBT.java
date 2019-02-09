package Tree;
import java.util.LinkedList;
import java.util.Queue;

public class RBT {
	
	class RBTNode {
		RBTNode left, right, parent;
		int key;
		String color;
		
		RBTNode(int data) {
			key = data;
			left = right = parent = null;
			color = "red";
		}
	}

	public RBTNode root;
	
	RBT() {
		root = null;
	}
	
	RBTNode insert(RBTNode root, RBTNode node) {
		
		if(root == null) {
			return node;
		}
		else if(root.key > node.key) {
			root.left = insert(root.left, node);
			root.left.parent = root;
		} else {
			root.right = insert(root.right, node);
			root.right.parent = root;
		}
		return root;
	}
	
	RBTNode rotateRight(RBTNode root, RBTNode y) {
		
		System.out.println("Y data: " + y.key);
		RBTNode x = y.left;
		System.out.println("X data: " + x.key);
		y.left = x.right;
		
		if(y.left != null) {
			y.left.parent = y;
		}
		x.parent = y.parent;
		
		if(y.parent == null) {
			root = x;
		}
		else if(y == y.parent.left) {
			y.parent.left = x;
		}
		else {
			y.parent.right = x;
		}
		
		x.right = y;
		y.parent = x;
		
		return root;
		
	}
	
	RBTNode rotateLeft(RBTNode root, RBTNode y) {
		
		RBTNode x = y.right;
		y.right = x.left;
		
		if(y.right != null) {
			y.right.parent = y;
		}
		
		x.parent = y.parent;
		
		if(y.parent == null) {
			root = x;
		}
		else if(y == y.parent.left) {
			y.parent.left = x;
		}
		else {
			y.parent.right = x;
		}
		
		x.left = y;
		y.parent = x; 
		
		return root;
	}
	
	RBTNode fixViolations(RBTNode root, RBTNode node) {
		
		RBTNode parent = null;
		RBTNode grandParent = null;
		while(node != root && node.color != "black" && node.parent.color == "red") {
			parent = node.parent;
			grandParent = node.parent.parent;
			
			if(parent == grandParent.left) {
				RBTNode uncle = grandParent.right;
				if(uncle != null && uncle.color == "red") {
					/** UNCLE IS RED
					1. recolor the uncle, parent = BLACK
					2. recolor root = RED
					3. make the node = root and recursively do 1 & 2
					**/
					parent.color = "black";
					uncle.color = "black";
					grandParent.color = "red";
					node = grandParent;
				}
				else {
					/** UNCLE IS BLACK
					 * Now have to determine if its line vs triangle model
					 */
					if(node == node.parent.right) {
						/** TRIANGLE MODEL
						 * 1. Perform rotation.
						 */
						root = rotateLeft(root, grandParent);
						node = parent;
						node.parent = parent.parent;
					} 
					/** LINE MODEL
					 * 1. Perform rotation
					 * 2. Recolor
					 */
					root = rotateRight(root, grandParent);
					System.out.println("New root is: " + root.key);
					
					// swap colors
					String temp = parent.color;
					parent.color = grandParent.color;
					grandParent.color = temp;
					node = parent;
				}
			} else {
				RBTNode uncle = grandParent.left;
				if(uncle != null && uncle.color == "red") {
					/** UNCLE IS RED
					1. recolor the uncle, parent = BLACK
					2. recolor root = RED
					3. make the node = root and recursively do 1 & 2
					**/
					parent.color = "black";
					uncle.color = "black";
					grandParent.color = "red";
					node = grandParent;
				} else {
					/** UNCLE IS BLACK
					 * Now have to determine if its line vs triangle model
					 */
					if(node == node.parent.left) {
						/** TRIANGLE MODEL
						 * 1. Perform rotation.
						 */
						root = rotateRight(root, grandParent);
						node = parent;
						node.parent = parent.parent;
					} 
					/** LINE MODEL
					 * 1. Perform rotation
					 * 2. Recolor
					 */
					root = rotateLeft(root, node);
					// Swap parent & grandParent colors
					String temp = parent.color;
					parent.color = grandParent.color;
					grandParent.color = temp;
					node = parent;
				}
			}
					
		}
		root.color = "black";
		return root;
	}
	RBTNode insertHelper(int data) {
		
		RBTNode node = new RBTNode(data);
		root = insert(root, node);
		System.out.println("Root value: " + root.key);
		return fixViolations(root, node);
	}
	
	void levelOrderHelper(RBTNode root) 
	{ 
	    if (root == null) 
	        return; 
	  
	    Queue<RBTNode> q = new LinkedList<RBTNode>();
	    q.add(root); 
	  
	    while (!q.isEmpty()) 
	    { 
	    	RBTNode temp = q.peek(); 
	        System.out.print(temp.key + ">"); 
	        q.poll(); 
	  
	        if (temp.left != null) {
	            q.add(temp.left); 
	        }
	        if (temp.right != null) { 
	            q.add(temp.right); 
	        }
	    } 
	}
	public void inOrder(RBTNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.key);
		System.out.print("->");
		inOrder(root.right);
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RBT tree = new RBT(); 
		  
	    tree.root = tree.insertHelper(7); 
	    tree.root = tree.insertHelper(6); 
	    tree.root = tree.insertHelper(5); 
	    tree.root = tree.insertHelper(4); 
	    tree.root = tree.insertHelper(3); 
	    tree.root = tree.insertHelper(2); 
	    tree.root = tree.insertHelper(1);
	    
	    System.out.println("Inoder Traversal of Created Tree");
	    tree.inOrder(tree.root);
	    System.out.println();
	    
	    System.out.println("Level Order Traversal of Created Tree");
	    tree.levelOrderHelper(tree.root);
	}

}
