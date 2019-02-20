package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

import Tree.BinarySearchTree.TreeNode;

/**
 * 
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.


 * @author vignesh
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CousinsBinaryTree {
    public class TreeNodeWithMoreInfo {
        TreeNode node;
        int height;
        TreeNode parent;
        TreeNodeWithMoreInfo(TreeNode n, int h, TreeNode p) {
            node = n;
            height = h;
            parent = p;
        }
        
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) return false;
        Deque<TreeNodeWithMoreInfo> queue = new ArrayDeque<>();
        
        TreeNodeWithMoreInfo node = new TreeNodeWithMoreInfo(root, 1, null);
        queue.offer(node);
        TreeNodeWithMoreInfo Xnode = null, Ynode = null;
        boolean xFound = false, yFound = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size != 0) {
                TreeNodeWithMoreInfo nodeWithMoreInfo = queue.poll();
                if(nodeWithMoreInfo.node.data == x){
                    xFound = true;
                    Xnode = nodeWithMoreInfo;
                }
                if(nodeWithMoreInfo.node.data == y){
                     yFound = true;
                     Ynode = nodeWithMoreInfo;
                }
                if(nodeWithMoreInfo.node.left != null) {
                    int heightOfLeftNode = nodeWithMoreInfo.height + 1;
                    TreeNode parent = nodeWithMoreInfo.node;
                    TreeNodeWithMoreInfo leftNode = new TreeNodeWithMoreInfo(nodeWithMoreInfo.node.left, heightOfLeftNode, parent);
                    queue.offer(leftNode);
                }
                if(nodeWithMoreInfo.node.right != null) {
                    int heightOfRightNode = nodeWithMoreInfo.height + 1;
                    TreeNode parent = nodeWithMoreInfo.node;
                    TreeNodeWithMoreInfo rightNode = new TreeNodeWithMoreInfo(nodeWithMoreInfo.node.right, heightOfRightNode, parent);
                    queue.offer(rightNode);
                }
                size--;
            }
            if(xFound && yFound) {
                if(checkIfXAndYAreEqual(Xnode, Ynode)) return true;
                else return false;
            }
        }
        return false;
    }
    
    public boolean checkIfXAndYAreEqual(TreeNodeWithMoreInfo a, TreeNodeWithMoreInfo b) {
        if(a.height == b.height) {
            if(a.parent != b.parent) return true;
            else return false;
        }
        return false;
    }
}
