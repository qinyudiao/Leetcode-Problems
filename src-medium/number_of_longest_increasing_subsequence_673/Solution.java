package number_of_longest_increasing_subsequence_673;

import java.util.Arrays;

//    Given an integer array nums, return the number of longest increasing subsequences.

//    Constraints:
//        0 <= nums.length <= 2000
//        -10^6 <= nums[i] <= 10^6

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{1, 3, 5, 4, 7}, {2, 2, 2, 2, 2}}; // 2, 5
        for(int[] testCase : testCases) {
            System.out.println(solution.findNumberOfLIS(testCase));
        }
    }
    
    public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        int[] lengths = new int[nums.length]; // lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[nums.length]; // counts[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);
        
        for(int j = 0; j < nums.length; j++) {
            for(int i = 0; i < j; i++) {
                if(nums[i] < nums[j]) {
                    if(lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    }
                    else if(lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }
        
        int longest = 0, ans = 0;
        for(int length : lengths) {
            longest = Math.max(longest, length);
        }
        for(int i = 0; i < nums.length; i++) {
            if(lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}
