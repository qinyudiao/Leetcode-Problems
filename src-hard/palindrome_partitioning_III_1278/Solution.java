package palindrome_partitioning_III_1278;

import java.util.ArrayList;

//	You are given a string s containing lowercase letters and an integer k. You need to :
//
//		First, change some characters of s to other lowercase English letters.
//		Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
//	
//	Return the minimal number of characters that you need to change to divide the string.
	
@SuppressWarnings("unused")
public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ArrayList<String> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		ArrayList<Integer> l3 = new ArrayList<>();
		
		l1.add("abc");
		l2.add(2);
		l3.add(1);
		
		l1.add("aabbc");
		l2.add(3);
		l3.add(0);
		
		l1.add("leetcode");
		l2.add(8);
		l3.add(0);
		
		
		for(int i=0; i<l1.size(); i++) {
//			System.out.println("Input: " + "\"" + l1.get(i) + "\", " + l2.get(i) + " Output: " + s.palindromePartition("abc", 2) + ", should be " + l3.get(i));
			System.out.println(s.palindromePartition(l1.get(i), l2.get(i)) == l3.get(i));
		}
	}
	
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