package Tree;

public class BinarySearchTree {
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	TreeNode root;
	
	BinarySearchTree() {
		root = null;
	}
	
	public TreeNode insert(TreeNode root, int data) {
		if(root == null) {
			root = new TreeNode(data);
			return root;
		}
		if(root.data > data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data);
		System.out.print("->");
		inOrder(root.right);
		return;
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data);
		System.out.print("->");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);
		System.out.print("->");
		
	}
	
	public Boolean search(TreeNode root, int data) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		if(root.data > data) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}
	
	public TreeNode delete(TreeNode root, int key) {
		
		if(root == null) { return null; }
		if(root.data > key) {
			root.left =  delete(root.left, key);
		} else if(root.data < key) {
			root.right = delete(root.right, key);
		} else {
			if(root.left == null) {
				return root.right;
			} else if(root.right == null){
				return root.left;
			}
			root.data = findInorderSuccessor(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
		
	}
	
	public int findInorderSuccessor(TreeNode root) {
	
		int min = root.data;
		while(root.left !=null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insert(bst.root, 4);
		bst.root = bst.insert(bst.root, 2);
		bst.root = bst.insert(bst.root, 7);
		bst.root = bst.insert(bst.root, 1);
		bst.root = bst.insert(bst.root, 3);
		bst.root = bst.insert(bst.root, 5);
		bst.root = bst.insert(bst.root, 8);
		
		System.out.println("Printing BST inorder.....");
		bst.inOrder(bst.root);
		System.out.println();
		
		System.out.println("Printing BST preorder.....");
		bst.preOrder(bst.root);
		System.out.println();
		
		System.out.println("Printing BST postorder.....");
		bst.postOrder(bst.root);
		System.out.println();
		
		System.out.println("Searching 5 within the BST.....");
		System.out.println("REsult:" + bst.search(bst.root, 5));
		System.out.println("Searching 10 within the BST.....");
		System.out.println("REsult:" + bst.search(bst.root, 8));
		
		System.out.println("Trying to delete element: 2");
		bst.delete(bst.root, 2);
		bst.preOrder(bst.root);
		System.out.println();
		
//		System.out.println("Trying to delete element: 7");
//		bst.delete(bst.root, 7);
//		bst.preOrder(bst.root);
		
	}

}
