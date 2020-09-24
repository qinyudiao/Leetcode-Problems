package word_pattern_290;

import java.util.HashMap;
import java.util.Map;

//	Given a pattern and a string str, 
//	find if str follows the same pattern.
//	
//	Here follow means a full match, 
//	such that there is a bijection between a letter in pattern and a non-empty word in str.

//	Notes:
//		You may assume pattern contains only lowercase letters, 
//		and str contains lowercase letters that may be separated by a single space.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCasesPattern = {"abba", "abba", "aaaa", "abba"};
		String[] testCasesStr = {"dog cat cat dog", "dog cat cat fish", "dog cat cat dog", "dog dog dog dog"};
		for(int i = 0; i < testCasesPattern.length; i++) {
			System.out.println(solution.wordPattern(testCasesPattern[i], testCasesStr[i]));	// true, false, false, false
		}
	}
	
	// Idea: use two HashMaps to save time from O(n) containsValue operation. Tradeoff: uses more memory.
	// O(n + m), where n is pattern.length() and m is number of words in str. 
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if(words.length != pattern.length())
			return false;
		
		Map<Character, String> mapChar = new HashMap<>(); // Space complexity: O(1), because there can only be 26 lowercase letters.
		Map<String, Character> mapWord = new HashMap<>(); // Space complexity: O(1), or O(m), where m is less than 26.
		for(int i = 0; i < pattern.length(); i++) {
			if(mapChar.containsKey(pattern.charAt(i))) {
				if(!mapChar.get(pattern.charAt(i)).equals(words[i]))
					return false;
			}
			else if(mapWord.containsKey(words[i]))
				return false;
			else {
				mapChar.put(pattern.charAt(i), words[i]);
				mapWord.put(words[i], pattern.charAt(i));
			}	
		}
		return true;
	}
	
	//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
	//	Memory Usage: 37.3 MB, less than 86.26% of Java online submissions for Word Pattern. 
	
	// Idea: use one HashMap. Tradeoff: takes more time.
	// O(n + m), where n is pattern.length() and m is number of words in str. 
	public boolean wordPattern1(String pattern, String str) {
		String[] words = str.split(" ");
		if(words.length != pattern.length())
			return false;
		
		Map<Character, String> map = new HashMap<>(); // Space complexity: O(1)
		for(int i = 0; i < pattern.length(); i++) {
			if(map.containsKey(pattern.charAt(i))) {
				if(!map.get(pattern.charAt(i)).equals(words[i]))
					return false;
			}
			else if(map.containsValue(words[i])) // containsValues() still takes O(1) because there are at most 26 values in the map.
				return false;
			else {
				map.put(pattern.charAt(i), words[i]);
			}	
		}
		return true;
	}

	//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
	//	Memory Usage: 37.1 MB, less than 97.50% of Java online submissions for Word Pattern.
}
