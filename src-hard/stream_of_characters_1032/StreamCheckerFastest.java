package stream_of_characters_1032;

import utilities.TrieFast;
import utilities.TrieNodeFast;

// insert and check reversely
public class StreamCheckerFastest {

	TrieFast trie = new TrieFast();
	StringBuilder reverseStream = new StringBuilder();
	
	public static void main(String[] args) {
		StreamCheckerFastest streamChecker = new StreamCheckerFastest(new String[] {"cd","f","kl"}); // init the dictionary.
		System.out.println(streamChecker.query('a'));          // return false
		System.out.println(streamChecker.query('b'));          // return false
		System.out.println(streamChecker.query('c'));          // return false
		System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
		System.out.println(streamChecker.query('e'));          // return false
		System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
		System.out.println(streamChecker.query('g'));          // return false
		System.out.println(streamChecker.query('h'));          // return false
		System.out.println(streamChecker.query('i'));          // return false
		System.out.println(streamChecker.query('j'));          // return false
		System.out.println(streamChecker.query('k'));          // return false
		System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
	}
	
    public StreamCheckerFastest(String[] words) {
    	for(String word : words) {
    		trie.insertReversely(word);
    	}
    }
    
    public boolean query(char letter) {
        reverseStream.append(letter);
        TrieNodeFast curr = trie.root;
        for(int i = reverseStream.length() - 1; i >= 0; i--) {
            char c = reverseStream.charAt(i);
            curr = curr.children[c - 'a'];
            if(curr == null)
            	break;
            if(curr.isCompleteWord) {
                return true;
            }
        }
        return false;
    }
}
