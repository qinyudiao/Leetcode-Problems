package detect_capital_use_520;

//	Given a word, you need to judge whether the usage of capitals in it is right or not.
//	
//	We define the usage of capitals in a word to be right when one of the following cases holds:
//		1. All letters in this word are capitals, like "USA".
//		2. All letters in this word are not capitals, like "leetcode".
//		3. Only the first letter in this word is capital, like "Google".
//	Otherwise, we define that this word doesn't use capitals in a right way.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCases = {"USA", "FLaG", "leetcode", "Google"}; // true, false, true, true
		for(String testCase : testCases) {
			System.out.println(solution.detectCapitalUse(testCase));	
		}
	}
	
	public boolean detectCapitalUse(String word) {
		if(word.length() == 1)
			return true;
		
		if(Character.isUpperCase(word.charAt(0))) { // true: upper, false: lower
			if(Character.isUpperCase(word.charAt(1))) {
				for (int i = 2; i < word.length(); i++) { 
					if(!Character.isUpperCase(word.charAt(i)))
						return false;
		        }
			} else {
				for (int i = 2; i < word.length(); i++) { 
					if(Character.isUpperCase(word.charAt(i)))
						return false;
		        }
			}
		} else {
			for (int i = 1; i < word.length(); i++) { 
				if(Character.isUpperCase(word.charAt(i)))
					return false;
	        }
		}
		
		return true;
    }
}

//	Runtime: 1 ms, faster than 99.53% of Java online submissions for Detect Capital.
//	Memory Usage: 38.2 MB, less than 43.03% of Java online submissions for Detect Capital.
