package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Tree.BinarySearchTree.TreeNode;


/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * 
 * Tag - Binary Search Tree..
 * 
 * 
 * @author vignesh
 *
 */
public class isValidBST {

	//Iterative solution...
	/*
	 * 
	 * Template for various BST problems
	 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/625/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	 */
	public boolean IsValidBST(TreeNode root) {
       if (root == null) return true;
       Deque<TreeNode> stack = new ArrayDeque<>();
       TreeNode pre = null;
       while (root != null || !stack.isEmpty()) {
          while (root != null) {
             stack.push(root);
             root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.data <= pre.data) return false;
          pre = root;
          root = root.right;
       }
       return true;
    }
	
	//recusrsive solution
//	public class Solution {
//	    public boolean isValidBST(TreeNode root) {
//	        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//	    }
//	    
//	    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
//	        if (root == null) return true;
//	        if (root.val >= maxVal || root.val <= minVal) return false;
//	        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
//	    }
//	}

}
