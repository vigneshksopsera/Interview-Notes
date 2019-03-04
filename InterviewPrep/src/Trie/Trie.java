package Trie;

import java.util.Map;
import java.util.HashMap;

/** Implement basic trie structure...
 * Q- https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
 * 
 * Tags - Trie
 * @author vignesh
 *
 */
class TrieNode {
	// Initialize your data structure here.
	private boolean isWord;
	private Map<Character, TrieNode> children;
	public TrieNode() {
	    isWord = false;
	    children = new HashMap<>();
	}
	public void setChildren(Map<Character, TrieNode> children) {
	    this.children = children;
	}

	public Map<Character, TrieNode> getChildren() {
	    return children;
	}

	public void setIsWord(boolean b) {
	    this.isWord = b;
	}

	public boolean getIsWord() {
	    return this.isWord;
	}
}

	public class Trie {
		private TrieNode root;
	
		public Trie() {
		    root = new TrieNode();
		}
	
		// Inserts a word into the trie.
		public void insert(String word) {
		    TrieNode node = root;
		    Map<Character, TrieNode> children;
		    for (char c: word.toCharArray()) {
		        children = node.getChildren();
		        if (!children.containsKey(c)) {
		            children.put((Character)c, new TrieNode());
		            node.setChildren(children);
		        }
		        node = node.getChildren().get(c);
		    }
		    node.setIsWord(true);
		}
	
		// Returns if the word is in the trie.
		public boolean search(String word) {
		    TrieNode node = root;
		    Map<Character, TrieNode> children;
		    for (char c: word.toCharArray()) {
		        children = node.getChildren();
		        if (!children.containsKey(c)) {
		            return false;
		        }
		        node = node.getChildren().get(c);
		    }
		    return node.getIsWord();
		}
	
		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
	    TrieNode node = root;
	    Map<Character, TrieNode> children;
	    for (char c: prefix.toCharArray()) {
	        children = node.getChildren();
	        if (!children.containsKey(c)) {
	            return false;
	        }
	        node = node.getChildren().get(c);
	    }
	    return true;
	} 
	}
