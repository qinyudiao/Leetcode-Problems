package utilities;

import java.util.HashMap;

public class TrieNode {
	
    private HashMap<Character, TrieNode> children;
	private boolean isCompleteWord;
	private String word;

	public TrieNode()
	{
	    children = new HashMap<Character, TrieNode>();
	}
	
	// getters and setters
	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}
	
    public boolean isCompleteWord() {
		return isCompleteWord;
	}

	public void setCompleteWord(boolean isCompleteWord) {
		this.isCompleteWord = isCompleteWord;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String toString() {
        return children.toString();
    }
}
