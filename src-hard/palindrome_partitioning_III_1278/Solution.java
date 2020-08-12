package palindrome_partitioning_III_1278;

//	You are given a string s containing lowercase letters and an integer k. You need to :
//
//		First, change some characters of s to other lowercase English letters.
//		Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
//	
//	Return the minimal number of characters that you need to change to divide the string.
	
@SuppressWarnings("unused")
public class Solution {
	
    public int palindromePartition(String s, int k) {
    	//	case 1: k == s.length
    	if(k==s.length())
    		return 0;
    	
    	
		int index = 1;
        return 2;
    }
    
    public boolean isPanlindrome(String s) {
        int start = 0;
        int end = s.length() - 1; 
  
        while (start < end) { 
            
            if (s.charAt(start) != s.charAt(end)) 
                return false; 
  
            start++; 
            end--; 
        } 
  
        return true; 
    }
    
}

// abcdef