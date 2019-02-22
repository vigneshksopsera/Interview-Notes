package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/789/


Tags - Tree, BFS traversals


 * @author vignesh
 *
 */


public class PopulatingNextRightPointers {
	public class CustomNode {
		int val;
		CustomNode left, right, next;
	}
	public CustomNode connect(CustomNode root) {
        
        if(root == null) return null;
        Deque<CustomNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size != 0) {
            	CustomNode node = queue.poll();
                size--;
                CustomNode nextNode = queue.peek();
                if(nextNode != null && size > 0) node.next = nextNode;
                else node.next = null;
                
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }

}
