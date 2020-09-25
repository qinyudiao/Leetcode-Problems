package utilities;

public class TrieNodeFast {

	public TrieNodeFast[] children; 
	public boolean isCompleteWord;

	public TrieNodeFast() {
		children = new TrieNodeFast[26];
		isCompleteWord = false;
	}

	public String toString() {
		return children.toString();
	}
}
