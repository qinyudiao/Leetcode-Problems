package top_k_frequent_words_692;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//	Given a non-empty list of words, return the k most frequent elements.
//	
//	Your answer should be sorted by frequency from highest to lowest. 
//	If two words have the same frequency, then the word with the lower alphabetical order comes first.

//	Note:
//		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//		Input words contain only lowercase letters.
	
//	Follow up:
//		Try to solve it in O(n log k) time and O(n) extra space.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"}; // ["i", "love"]
		System.out.println(solution.topKFrequent(words1, 2));
		
		String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; // ["the", "is", "sunny", "day"]
		System.out.println(solution.topKFrequent(words2, 4));
	}

	// Idea:
	//	Put the words and their number of occurrences in an unsorted map, 
	//	then sort the values and make first k values as keys of a new sorted map.
	//	Iterate through the words of the unsorted map's keySet.
	//	If a word's number of occurrences matches a key in the sorted map,
	//	add that word to the list of that key, and after that, sort all the lists.
	//	Add first k Strings in the sorted map to the result.
	
	// Time Complexity: O(n*log(k))
	// Space Complexity: O(n)
	public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
		Map<String, Integer> unsortedMap = new HashMap<>(); // O(n) space
		// O(n) time
		for(String word : words) {
			if(!unsortedMap.containsKey(word))
				unsortedMap.put(word, 1);
			else
				unsortedMap.put(word, unsortedMap.get(word) + 1);
		}
		
		List<Integer> values = new ArrayList<>(unsortedMap.size());
		values.addAll(unsortedMap.values());
		Collections.sort(values, Collections.reverseOrder());
		
		Map<Integer, List<String>> sortedMap = new HashMap<>(); // O(n) space, at most a total of n words in all the lists.
		
		// O(k) time
		for(int i = 0; i < k; i++) {
			if(!sortedMap.containsKey(values.get(i)))
				sortedMap.put(values.get(i), new ArrayList<>());
		}
		
		for(String word : unsortedMap.keySet()) {
			if(sortedMap.containsKey(unsortedMap.get(word))) {
				List<String> list = sortedMap.get(unsortedMap.get(word));
				list.add(word);
			}
		}
		// O(n*log(k)) time
		int count = 0;
		List<Integer> keys = new ArrayList<>(sortedMap.keySet());
		Collections.reverse(keys);
		for(int key : keys) {
			List<String> list = sortedMap.get(key);
			Collections.sort(list);
			for(String word : list) {
				result.add(word);
				count++;
				if(count >= k)
					break;
			}
		}
		
		return result;
    }
}

//	Runtime: 7 ms, faster than 53.60% of Java online submissions for Top K Frequent Words.
//	Memory Usage: 39.6 MB, less than 84.26% of Java online submissions for Top K Frequent Words.
