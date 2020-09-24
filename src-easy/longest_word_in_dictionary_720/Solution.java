package longest_word_in_dictionary_720;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import utilities.Trie;
import utilities.TrieNode;

//	Given a list of strings words representing an English Dictionary, 
//	find the longest word in words that can be built one character at a time by other words in words. 
//	If there is more than one possible answer, 
//	return the longest word with the smallest lexicographical order.

//	If there is no answer, return the empty string.
		
//	Note:
//		All the strings in the input will only contain lowercase letters.
//		The length of words will be in the range [1, 1000].
//		The length of words[i] will be in the range [1, 30].

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[][] testCases = {{"a"}, {"w", "wo", "wor", "worl", "world"}, {"a", "banana", "app", "appl", "ap", "apply", "apple", "bb"},
				{"a", "cc", "zed", "banana", "ze", "app", "appl", "ap", "apply", "z", "zedddd", "apple", "bb", "ti", "worl", "wo", "wor", "w", "world", "zeddd", "zedd"}}; // "a", world, apple, zeddddd
		for(String[] testCase : testCases) {
			System.out.println(solution.longestWord(testCase));	
		}
	}
	
	// Use Trie to save time because we know all the words only contain lower case letter.
	// O(n*m), where n is the number of words, m is the length of longestWord.
	// this one is faster on average because the average length of a word is very small, plus that there are many words stored in the same trie path.
	public String longestWord(String[] words) {
//		long startTime = System.nanoTime();
		
		Trie trie = new Trie();
		
		// build the trie
		// O(n*m), because there are n words, each insert takes O(m)
		for(String word : words) {
			trie.insert(word);
		}
		
		// find the longest word
		// run BFS to traverse through the Trie
		// O(n*m), because there are at most n*(2m-1) nodes + paths
		String longestWord = "";
		
		Queue<TrieNode> queue = new LinkedList<>();
		
		queue.add(trie.getRoot());
		TrieNode curr = null;
		
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			if(curr.isCompleteWord() && curr.getWord().length() >= longestWord.length()) {
				if(curr.getWord().length() > longestWord.length())
					longestWord = curr.getWord();
				else if(curr.getWord().compareTo(longestWord) < 0)
					longestWord = curr.getWord();
			}
				
			HashMap<Character, TrieNode> children = curr.getChildren();
			for(char c : children.keySet()) {
				if(children.get(c).isCompleteWord())
					queue.add(children.get(c));
			}
		}
		
//		System.out.println(trie);
		
//		long endTime = System.nanoTime();
//		System.out.println("Execution time in nanoseconds  : " + (endTime - startTime));
		return longestWord;
	}
	
	// O(n*log(n)), where n is the number of words
	public String longestWord1(String[] words) {
//		long startTime = System.nanoTime();
		
		Arrays.sort(words); // tim sort by alphabetic order, O(n*log(n))
		System.out.println(Arrays.toString(words));
		
//		long time1 = System.nanoTime();
		
		int longest_index = 0;
		int longest_length = 0;
		Set<String> prefixes = new HashSet<>();
		prefixes.add("");
		for(int i = 0; i < words.length; i++) { // O(n)
			String word = words[i];
			if(prefixes.contains(word.substring(0, word.length() - 1))) {
				prefixes.add(word);
				if(word.length() > longest_length) {
					longest_index = i;
					longest_length = word.length();
				}
			}
		}
		
//		long endTime = System.nanoTime();
//		System.out.println("Execution time in nanoseconds  : " + (endTime - startTime) + " first:" + (time1 - startTime) + " second:" + (endTime - time1));
		
		return longest_length > 0 ? words[longest_index] : "";
	}
}
