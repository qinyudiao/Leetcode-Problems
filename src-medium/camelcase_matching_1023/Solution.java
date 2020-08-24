package camelcase_matching_1023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.Trie;
import utilities.TrieNode;

//	A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. 
//	(We may insert each character at any position, and may insert 0 characters.)
//	
//	Given a list of queries, and a pattern, 
//	return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.
		
//	Note:
//		1. 1 <= queries.length <= 100
//		2. 1 <= queries[i].length <= 100
//		3. 1 <= pattern.length <= 100
//		4. All strings consists only of lower and upper case English letters.

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] queries1 = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
		
		String pattern1 = "FB";
		System.out.println(solution.camelMatch(queries1, pattern1)); // [true, false, true, true, false]
		
		String pattern2 = "FoBa";
		System.out.println(solution.camelMatch(queries1, pattern2)); // [true, false, true, false, false]
		
		String pattern3 = "FoBaT";
		System.out.println(solution.camelMatch(queries1, pattern3)); // [false, true, false, false, false]
		
		String[] queries2 = {"CompetitiveProgramming", "CounterPick", "ControlPanel"};
		String pattern4 = "CooP";
		System.out.println(solution.camelMatch(queries2, pattern4)); // [false, false, true]
	}

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        
        for (String query : queries) {
        	int count = 0;
        	int size = result.size();
            for (int i = 0; i < query.length(); i++) {
            	char c = query.charAt(i);
                if (count < pattern.length() && c == pattern.charAt(count)) {
                    count++;
                } else if (Character.isUpperCase(c)) {
                	result.add(false);
                    break;
                }
            }
            if(size == result.size())
            	result.add(pattern.length() == count);
        }
        
        return result;
    }
    
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Camelcase Matching.
//    Memory Usage: 37.2 MB, less than 94.81% of Java online submissions for Camelcase Matching.
    
	// use Trie structure, works but slow because the HashSet children is not optimal
	public List<Boolean> camelMatch1(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		
		for(String query : queries) {
			Trie trie = new Trie();
			trie.insert(query);
			
			// Retrieve the subPatterns
			Queue<String> subPatterns = new LinkedList<>();
			StringBuilder subPattern = new StringBuilder();
			for(int i = 0; i < pattern.length(); i++) {
				subPattern.append(pattern.charAt(i));
				if((i == pattern.length() - 1) || Character.isUpperCase(pattern.charAt(i + 1))) {
					subPatterns.add(subPattern.toString());
					subPattern.setLength(0);
				}
			}
			
			// Check if the trie contains all the subPattens in order
			TrieNode curr = trie.getRoot();
			
			int size = result.size();
			outerloop:
			while(!subPatterns.isEmpty()) {
				String currPattern = subPatterns.poll();
				boolean currPatternMatched = false;
				for(int i = 0; i < currPattern.length(); i++) {
					char c = currPattern.charAt(i); // current pattern's character
					while(!curr.getChildren().isEmpty()) { 
						HashMap<Character, TrieNode> children = curr.getChildren();
						Character[] trieNodeChar = new Character[1];
						children.keySet().toArray(trieNodeChar);
						curr = children.get(trieNodeChar[0]);
						if(c == trieNodeChar[0]) {
							if(i == currPattern.length() - 1)
								currPatternMatched = true;
							break;
						}
						else if(Character.isUpperCase(trieNodeChar[0])) { // if there's another not matched upper case letter, then is not matched
							result.add(false);
							break outerloop;
						}
					}
					
				}
				
				if(!currPatternMatched) {
					result.add(false);
					break;
				}
			}
			
			// check if there's upper case letter left
			while(!curr.getChildren().isEmpty()) { 
				HashMap<Character, TrieNode> children = curr.getChildren();
				Character[] trieNodeChar = new Character[1];
				children.keySet().toArray(trieNodeChar);
				if(Character.isUpperCase(trieNodeChar[0])) {
					if(result.size() == size)
						result.add(false);
					break;
				}
				curr = children.get(trieNodeChar[0]);
			}
			
			if(result.size() == size)
				result.add(true);
		}
		
		return result;
    }
}
