package utilities;

public class TrieFast {

	public TrieNodeFast root;

	public TrieFast() {
		root = new TrieNodeFast();
	}

	public void insert(String word) {
		TrieNodeFast curr = root;

		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNodeFast(); 
			}
			curr = curr.children[c - 'a'];  
		}

		curr.isCompleteWord = true;
	}

	public void insertReversely(String word) {
		TrieNodeFast curr = root;

		for(int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNodeFast(); 
			}
			curr = curr.children[c - 'a'];  
		}

		curr.isCompleteWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNodeFast curr = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];  
		}

		return curr.isCompleteWord ? true : false;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNodeFast curr = root;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(curr.children[c - 'a'] == null)
				return false;
			curr = curr.children[c - 'a'];  
		}

		return true;
	}

	public String toString() {
		return root.toString();
	}
}

//	Runtime: 81 ms, faster than 97.59% of Java online submissions for Stream of Characters.
//	Memory Usage: 73.1 MB, less than 64.02% of Java online submissions for Stream of Characters.
