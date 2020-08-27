package design_add_and_search_words_data_structure_211;

import utilities.TrieNodeFast;

//	You should design a data structure that supports adding new words and finding 
//	if a string matches any previously added string.
//
//	Implement the WordDictionary class:
//		WordDictionary() Initializes the object.
//		void addWord(word) adds word to the data structure, it can be matched later.
//		bool search(word) returns true if there is any string in the data structure that matches word or false otherwise. 
//		word may contain dots '.' where dots can be matched with any letter.

//	Constraints:
//		1 <= word.length <= 500
//		word in addWord consists lower-case English letters.
//		word in search consist of  '.' or lower-case English letters.
//		At most 50000 calls will be made to addWord and search .

public class WordDictionary {
	
	public TrieNodeFast root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNodeFast();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchDfs(word, 0, root);
    }
    
    public boolean searchDfs(String word, int start, TrieNodeFast curr) {
    	for(int i = start; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if(c != '.') {
        		if(curr.children[c - 'a'] == null)
            		return false;
            	curr = curr.children[c - 'a'];
        	} else {
        		for(int j = 0; j < 26; j++) {
        			if(curr.children[j] != null && searchDfs(word, i+1, curr.children[j])) {
        				return true;
        			}
        		}
        		return false;
        	}
        }
    	
    	return curr.isCompleteWord ? true : false;
    }
}

//	Runtime: 36 ms, faster than 98.52% of Java online submissions for Design Add and Search Words Data Structure.
//	Memory Usage: 50.4 MB, less than 84.33% of Java online submissions for Design Add and Search Words Data Structure.
