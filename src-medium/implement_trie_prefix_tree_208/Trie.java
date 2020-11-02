package implement_trie_prefix_tree_208;

public class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        
        curr.isCompleteWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        
        return curr.isCompleteWord ? true : false;
    }
    
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        
        return true;
    }
}

class TrieNode {
    
    public TrieNode[] children;
    public boolean isCompleteWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        isCompleteWord = false;
    }
}

//	Runtime: 30 ms, faster than 92.79% of Java online submissions for Implement Trie (Prefix Tree).
//	Memory Usage: 48.9 MB, less than 79.34% of Java online submissions for Implement Trie (Prefix Tree).
