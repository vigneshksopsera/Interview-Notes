package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.BinarySearchTree.TreeNode;

/***
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Tags -  BST, Traversals
 * 
 * @author vignesh
 *
 */

public class KthSmallestElementInBST {
	
	public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) return -1;
        List<Integer> inOrderList = new ArrayList<>();
        helper(root, inOrderList);
        return inOrderList.get(k-1);
    }
    
    public void helper(TreeNode root, List<Integer> list) {
        
        if(root == null) return;
        
        helper(root.left, list);
        list.add(root.data);
        helper(root.right, list);
        
        return;
    }

}
