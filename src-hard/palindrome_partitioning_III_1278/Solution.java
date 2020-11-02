package palindrome_partitioning_III_1278;

import java.util.ArrayList;

//	You are given a string s containing lowercase letters and an integer k. You need to :
//
//		First, change some characters of s to other lowercase English letters.
//		Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
//	
//	Return the minimal number of characters that you need to change to divide the string.

//	1 <= k <= s.length <= 100.
//	s only contains lowercase English letters.

public class Solution {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        
        l1.add("abc"); // 1
        l2.add(2);
        
        l1.add("aabbc"); // 0
        l2.add(3);
        
        l1.add("leetcode"); // 0
        l2.add(8);
        
        for(int i = 0; i < l1.size(); i++) {
            System.out.println("result " + i + ": " + s.palindromePartition(l1.get(i), l2.get(i)));
        }
    }
    
    // uses a second 2d array to store the steps to avoid duplicated calculations in
    // each stepsToPanlindrome() call
    // O(l*n^2), where l is k and n is s.length()
    public int palindromePartition(String s, int k) {
        int n = s.length();
        if(n <= k)
            return 0;
        
        int[][] steps = new int[n][n]; // stores the steps(substring.startIndex, substring.endIndex-1)
        int[][] dp = new int[n][k]; // stores the minimal number for each substring starts with 0, and with length =
                                    // n +1, number of subtrings can be divided into = k + 1
        
        for(int j = 1; j < n; j++) { // starts with j = 1 because length 1 string is palindrome => steps[0][0] == 0
            for(int i = 0; i <= j - 1; i++) { // ends with i = j - 1 beacause steps[i][j] == 0 when i == j
                steps[i][j] = steps[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        
//		print2DArray(steps);
        
        for(int i = 0; i < n; i++) { // store the number of changes needed for each substring starts from index 0
            dp[i][0] = steps[0][i];
        }
        
        for(int l = 1; l < k; l++) { // l is the number of substrings can be divided into
            for(int j = l; j < n; j++) { // j is substring.endIndex-1
                int min = Integer.MAX_VALUE;
                for(int i = 0; i <= j - 1; i++) { // i is substring.startIndex
                    min = Math.min(min, dp[i][l - 1] + steps[i + 1][j]); // for string starts wth n = 3 and k = 3, dp[2][2] = min((dp[0][1] +
                                                                         // steps[1][2]), (dp[1][1] + steps[2][2]))
                }
                dp[j][l] = min;
            }
        }
        
        return dp[n - 1][k - 1];
    }
    
//    Runtime: 3 ms, faster than 98.38% of Java online submissions for Palindrome Partitioning III.
//    Memory Usage: 37.5 MB, less than 71.10% of Java online submissions for Palindrome Partitioning III.
    
    // only uses one dp, causing it some extra runtime.
    // O(l*n^3)
    public int palindromePartition1(String s, int k) {
        int n = s.length();
        if(n == k)
            return 0;
        
        int[][] dp = new int[n][k]; // stores the minimal number for each substring with each k
        
        for(int i = 0; i < n; i++) { // store the number of changes needed for each substring starts from index 0
            dp[i][0] = stepsToPanlindrome(s.substring(0, i + 1));
        }
        
        for(int j = 1; j < k; j++) {
            for(int i = j + 1; i < s.length(); i++) {
                dp[i][j] = Integer.MAX_VALUE;
                String last = "";
                for(int l = i; l > j - 1; l--) {
                    last = s.charAt(l) + last;
                    dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - 1] + stepsToPanlindrome(last));
                }
            }
        }
        
        return dp[n - 1][k - 1];
    }
    
    // T(n) = O(n)
    public int stepsToPanlindrome(String s) {
        int count = 0;
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                count++;
            
            start++;
            end--;
        }
        
        return count;
    }
}
