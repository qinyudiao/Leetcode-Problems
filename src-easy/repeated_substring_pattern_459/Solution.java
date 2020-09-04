package repeated_substring_pattern_459;

//	Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
//	You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] testCases = {"abab", "aba", "abcabcabcabc", "abacababacab"}; // true, false, true, true
		for(String testCase : testCases) {
			System.out.println(solution.repeatedSubstringPattern(testCase));
		}
	}

	// idea: check all valid length, if all substrings match, return true
	public boolean repeatedSubstringPattern(String s) {
		if(s.length() < 2)
			return false;
		
		for(int l = s.length()/2; l > 0; l--) {
			if(s.length() % l == 0) {
				boolean isRepeated = true;
				outer:
				for(int j = 0; j < l; j++) {
					char c = s.charAt(j);
					for(int i = 1; i * l < s.length(); i++) {
						if(s.charAt(i * l + j) != c) {
							isRepeated = false;
							break outer;
						}
					}
				}
				if(isRepeated)
					return true;
			}
		}
		
		return false;
    }
}
