package find_common_characters_1002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//	Given an array A of strings made only from lowercase letters, 
//	return a list of all characters that show up in all strings within the list (including duplicates). 
//	For example, if a character occurs 3 times in all strings but not 4 times, 
//	you need to include that character three times in the final answer.
//	
//	You may return the answer in any order.

//	Note:
//		1. 1 <= A.length <= 100
//		2. 1 <= A[i].length <= 100
//		3. A[i][j] is a lowercase letter

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[][] testCases = {{"bella", "label", "roller"}, {"cool", "lock", "cook"}}; // ["e","l","l"], ["c","o"]
        
        for(String[] testCase : testCases) {
            System.out.println(solution.commonChars(testCase));
        }
    }
    
    // because we know there's only 26 lower case letters, using int[] will be much
    // faster for some test cases.
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int j = 0; j < A[0].length(); j++) {
            char c = A[0].charAt(j);
            map.put(c, map.keySet().contains(c) ? map.get(c) + 1 : 1);
        }
        
        for(int i = 0; i < A.length; i++) { // update the number of a letter in each String if it is smallest.
            String s = A[i];
            
            Map<Character, Integer> countMap = new HashMap<>();
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(map.keySet().contains(c))
                    countMap.put(c, countMap.keySet().contains(c) ? countMap.get(c) + 1 : 1);
            }
            map.keySet().removeIf(key -> !countMap.containsKey(key)); // remove letters which didn't appear in the new String
            
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                map.put(entry.getKey(), Math.min(map.get(entry.getKey()), countMap.get(entry.getKey())));
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()) { // add final repeated letters to the result
            for(int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey().toString());
            }
        }
        
        return result;
    }
    
    // another solution
    public List<String> commonChars1(String[] A) {
        List<String> result = new ArrayList<>();
        
        List<Map<Character, Integer>> list = new ArrayList<>();
        
        int shortestStringIndex = 0;
        for(int i = 0; i < A.length; i++) {
            String s = A[i];
            if(s.length() < A[shortestStringIndex].length()) {
                shortestStringIndex = i;
            }
            Map<Character, Integer> map = new HashMap<>();
            list.add(map);
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.keySet().contains(c) ? map.get(c) + 1 : 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : list.get(shortestStringIndex).entrySet()) {
            Character key = entry.getKey();
            int count = entry.getValue();
            for(Map<Character, Integer> map : list) {
                if(!map.keySet().contains(key)) {
                    count = 0;
                    break;
                }
                else if(map.get(key) < count)
                    count = map.get(key);
            }
            for(int i = 0; i < count; i++) {
                result.add(key.toString());
            }
        }
        
        return result;
    }
}
