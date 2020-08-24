package utilities;

public class TrieNodeFast {
	
    public TrieNodeFast[] children; 
    public boolean isCompleteWord;
    
    TrieNodeFast() {
    	children = new TrieNodeFast[26];
    	isCompleteWord = false;
    }
}
