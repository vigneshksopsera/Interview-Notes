package Dfs;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * 
 * Q - https://leetcode.com/explore/featured/card/queue-stack/232/practical-application-stack/1392
 * 
 * Tags - DFS, Medium
 * @author vignesh
 *
 */
public class CloneGraph {
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};
	private Map<Integer, Node> mapOfNewNodes = new HashMap<>();
    public Node cloneGraph(Node node) {  
        
        if(node == null) return null;
        return dfs(node);
    }
    
    public Node dfs(Node node) {
        if(node == null) return null;
        if(mapOfNewNodes.containsKey(node.val)) {
            return mapOfNewNodes.get(node.val);
        }
        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new LinkedList<>();
        mapOfNewNodes.put(newNode.val, newNode);
        for(Node neighbor: node.neighbors) {
            //System.out.println("Neighbor: " + n.val);
            newNode.neighbors.add(dfs(neighbor));
            //System.out.println("added n: " + n.val + " to newNode: " + newNode.val);
        }
        return newNode;
    }

}
