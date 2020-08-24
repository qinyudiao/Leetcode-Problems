package utilities;

import java.util.HashMap;

public class Trie {
	
	protected TrieNode root;

	public Trie() {
		root = new TrieNode();
	}
	
	public Trie(TrieNode root) {
		this.root = root;
	}
	
	public void insert(String word) {
		TrieNode curr = root;
		
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			HashMap<Character, TrieNode> children = curr.getChildren();
			if(!children.containsKey(c)) {
				children.put(c, new TrieNode());
				curr.setChildren(children);
			}
			curr = children.get(c);
        }
		
		curr.setCompleteWord(true);
		curr.setWord(word);
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	public void setRoot(TrieNode root) {
		this.root = root;
	}
	
	public String toString() {
        return root.toString();
    }
}
