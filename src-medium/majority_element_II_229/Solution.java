package majority_element_II_229;

import java.util.ArrayList;
import java.util.List;

//	Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

//	Note: The algorithm should run in linear time and in O(1) space.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{3, 2, 3}, {1, 1, 1, 3, 3, 2, 2, 2}, {1, 1, 1, 2, 3, 4, 5, 6}, {2, 2, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9, 3, 9},
                {1, 2}, {1, 2, 2, 3, 2, 1, 1, 3}}; // [3], [1, 2], [1], [9, 3], [1, 2], [1, 2]
        for(int[] testCase : testCases) {
            System.out.println(solution.majorityElement(testCase));
        }
    }
    
    // Idea: Boyer-Moore Voting Algorithm.
    // Use two candidate variables and two counters to track the two candidates.
    // If the current element is equal to one of the potential candidate,
    // the count for that candidate is increased while leaving the count of the
    // other candidate as it is.
    // If the counter reaches zero,
    // the candidate associated with that counter will be replaced with the next
    // element
    // if the next element is not equal to the other candidate as well.
    // Both counters are decremented only when the current element is different from
    // both candidates.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return candidates;
        if(nums.length == 2) {
            candidates.add(nums[0]);
            if(nums[0] != nums[1])
                candidates.add(nums[1]);
            return candidates;
        }
        
        int candidate1 = nums[0];
        Integer candidate2 = null;
        int count1 = 1;
        int count2 = 0;
        
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] == candidate1)
                count1++;
            else if(candidate2 == null) {
                candidate2 = nums[i];
                count2++;
            }
            else if(nums[i] == candidate2)
                count2++;
            else {
                count2--;
                count1--;
            }
            if(count1 == 0 && nums[i + 1] != candidate2)
                candidate1 = nums[i + 1];
            else if(count2 == 0 && nums[i + 1] != candidate1)
                candidate2 = nums[i + 1];
        }
        
        // if all the elements are the same
        if(candidate2 == null) {
            candidates.add(candidate1);
            return candidates;
        }
        
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1)
                count1++;
            else if(num == candidate2)
                count2++;
        }
        
        if(count1 > nums.length / 3)
            candidates.add(candidate1);
        if(count2 > nums.length / 3)
            candidates.add(candidate2);
        
        return candidates;
    }
}

//	Runtime: 2 ms, faster than 72.73% of Java online submissions for Majority Element II.
//	Memory Usage: 43.3 MB, less than 67.80% of Java online submissions for Majority Element II.
