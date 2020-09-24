package stream_of_characters_1032;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TrieFast;
import utilities.TrieNodeFast;

// Use TrieFast
public class StreamCheckerFast {
	
	TrieFast trie = new TrieFast();
	Queue<TrieNodeFast> queue = new LinkedList<>(); // use to store all the TrieNodes
	
	public static void main(String[] args) {
		StreamCheckerFast streamChecker = new StreamCheckerFast(new String[] {"cd","f","kl"}); // init the dictionary.
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
	
	public StreamCheckerFast(String[] words) {
		for(String word : words) {
			trie.insert(word);
		}
	}
    
	public boolean query(char letter) {
		Queue<TrieNodeFast> queueNext = new LinkedList<>();

		queue.add(trie.root);
		TrieNodeFast curr = null;
		boolean isFound = false;
		while(!queue.isEmpty()) {
			curr = queue.poll();

			if(curr.children[letter - 'a'] != null) {
				queueNext.add(curr.children[letter - 'a']);
				if(curr.children[letter - 'a'].isCompleteWord)
					isFound = true;
			}
		}

		queue.addAll(queueNext);

		return isFound;
	}
}
