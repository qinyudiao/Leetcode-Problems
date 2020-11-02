package stream_of_characters_1032;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import utilities.Trie;
import utilities.TrieNode;

//	Implement the StreamChecker class as follows:
//		1. StreamChecker(words): Constructor, init the data structure with the given words.
//		2. query(letter): returns true if and only if for some k >= 1, 
//			the last k characters queried (in order from oldest to newest, 
//			including this letter just queried) spell one of the words in the given list.

//	Note:
//		1 <= words.length <= 2000
//		1 <= words[i].length <= 2000
//		Words will only consist of lowercase English letters.
//		Queries will only consist of lowercase English letters.
//		The number of queries is at most 40000.

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */

public class StreamChecker {
    
    Trie trie = new Trie();
    Queue<TrieNode> queue = new LinkedList<>(); // use to store all the TrieNodes
    
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[] {"cd", "f", "kl"}); // init the dictionary.
        System.out.println(streamChecker.query('a')); // return false
        System.out.println(streamChecker.query('b')); // return false
        System.out.println(streamChecker.query('c')); // return false
        System.out.println(streamChecker.query('d')); // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e')); // return false
        System.out.println(streamChecker.query('f')); // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g')); // return false
        System.out.println(streamChecker.query('h')); // return false
        System.out.println(streamChecker.query('i')); // return false
        System.out.println(streamChecker.query('j')); // return false
        System.out.println(streamChecker.query('k')); // return false
        System.out.println(streamChecker.query('l')); // return true, because 'kl' is in the wordlist
    }
    
    public StreamChecker(String[] words) {
        for(String word : words) {
            trie.insert(word);
        }
    }
    
    public boolean query(char letter) {
        Queue<TrieNode> queueNext = new LinkedList<>();
        
        queue.add(trie.getRoot());
        TrieNode curr = null;
        boolean isFound = false;
        while(!queue.isEmpty()) {
            curr = queue.poll();
            
            HashMap<Character, TrieNode> children = curr.getChildren();
            if(children.containsKey(letter)) {
                queueNext.add(children.get(letter));
                if(children.get(letter).isCompleteWord())
                    isFound = true;
            }
        }
        
        queue.addAll(queueNext);
        
        return isFound;
    }
}
