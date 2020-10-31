package longest_increasing_subsequence_300;

import java.util.Arrays;

//  Given an unsorted array of integers, find the length of longest increasing subsequence.

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(new Solution().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 1, 2, 4, 6, 7})); // 5
    }
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for(int num : nums) {
            int i = Arrays.binarySearch(dp, 0, length, num);
            if(i < 0)
                i = -(i + 1);
            dp[i] = num;
            if(i == length)
                length++;
            
            System.out.println(i + Arrays.toString(dp));
        }
        
        return length;
    }
}
