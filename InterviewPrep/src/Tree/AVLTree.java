package Tree;

public class AVLTree {
	
	class AVLNode {
		int key;
		int height;
		AVLNode left;
		AVLNode right;
		
		AVLNode(int d) {
			key = d;
			height = 1;
			left = right = null;
		}
	}
	
	AVLNode root;
	
	int height(AVLNode node) {
		
		if(node==null) return 0;
		else {
			return node.height;
		}	
	}
	
	int max(int left, int right) {
		return left > right ? left : right;
	}
	
	int getBalance(AVLNode node) {
		if(node == null) return 0;
		else {
			return height(node.left) - height(node.right);
		}
	}
	
	AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		AVLNode t2 = y.left;
		
		//perform rotation
		y.left = x;
		x.right = t2;
		
		//re-calculate height
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
	}
	
	AVLNode rightRotate(AVLNode x) {
		AVLNode y = x.left;
		AVLNode t2 = y.right;
		
		//perform rotation
		y.right = x;
		x.left = t2;
		
		//re-calculate height
		x.height = 1 + max(height(x.left), height(x.right));
		y.height = 1 + max(height(y.left), height(y.right));
		
		return y;
	}
	
	int minValueNode(AVLNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node.key;
	}
	
	AVLNode insert(AVLNode node, int data) {
		if(node == null) {
			node = new AVLNode(data);
			return node;
		}
		if(node.key > data) {
			node.left = insert(node.left, data);
		} else if(node.key < data){
			node.right = insert(node.right, data);
		} else return node;
		
		node.height = 1 + max(height(node.left), height(node.right));
		
		int balance = getBalance(node);
		
		if(balance > 1 && node.left.key > data) {
			// left-left case
			return rightRotate(node);
		}
		if(balance > 1 && node.left.key < data) {
			// left-right case
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && node.right.key < data) {
			// right-right case
			return leftRotate(node);
		}
		if(balance < -1 && node.right.key > data) {
			// right-left case
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	
	AVLNode deleteNode(AVLNode node, int data) {
		if(node == null) {
			node = new AVLNode(data);
			return node;
		}
		if(node.key > data) {
			node.left = deleteNode(node.left, data);
		} else if (node.key < data){
			node.right = deleteNode(node.right, data);
		}
		else {
			if(node.left == null) {
				node = node.right;
			}
			else if(node.right == null) {
				node = node.left;
			}
			else {
				node.key = minValueNode(node.right);
				node.right = deleteNode(node.right, node.key);
			}
		}
		
		node.height = 1 + max(height(node.left), height(node.right));
		
		int balance = getBalance(node);
		
		if(balance > 1 && getBalance(node.left) >= 0) {
			// left-left case
			return rightRotate(node);
		}
		if(balance > 1 && getBalance(node.left) < 0) {
			// left-right case
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		if(balance < -1 && getBalance(node.right) <= 0) {
			// right-right case
			return leftRotate(node);
		}
		if(balance < -1 && getBalance(node.right) > 0) {
			// right-left case
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	
	public void preOrder(AVLNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.key);
		System.out.print("->");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AVLTree tree = new AVLTree();  
		tree.root = null;  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 9);  
        tree.root = tree.insert(tree.root, 5);  
        tree.root = tree.insert(tree.root, 10);  
        tree.root = tree.insert(tree.root, 0);  
        tree.root = tree.insert(tree.root, 6);  
        tree.root = tree.insert(tree.root, 11);  
        tree.root = tree.insert(tree.root, -1);  
        tree.root = tree.insert(tree.root, 1);  
        tree.root = tree.insert(tree.root, 2);  
  
        /* The constructed AVL Tree would be  
        9  
        / \  
        1 10  
        / \ \  
        0 5 11  
        / / \  
        -1 2 6  
        */
        System.out.println("Preorder traversal of "+  
                            "constructed tree is : ");  
        tree.preOrder(tree.root);  
  
        tree.root = tree.deleteNode(tree.root, 10);  
  
        /* The AVL Tree after deletion of 10  
        1  
        / \  
        0 9  
        /     / \  
        -1 5 11  
        / \  
        2 6  
        */
        System.out.println("");  
        System.out.println("Preorder traversal after "+  
                        "deletion of 10 :");  
        tree.preOrder(tree.root);  

	}

}
