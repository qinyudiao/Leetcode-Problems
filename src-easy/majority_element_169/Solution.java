package majority_element_169;

import java.util.HashMap;
import java.util.Map;

//	Given an array of size n, find the majority element. 
//	The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//	
//	You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{3, 2, 3}, {2, 2, 1, 1, 1, 2, 2}}; // 3, 2
        for(int[] testCase : testCases) {
            System.out.println(solution.majorityElement(testCase));
        }
    }
    
    // S(n) = O(1).
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(candidate == nums[i])
                count++;
            else
                count--;
            if(count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        
        return candidate;
    }
    
//	Runtime: 1 ms, faster than 99.93% of Java online submissions for Majority Element.
//	Memory Usage: 43 MB, less than 66.60% of Java online submissions for Majority Element.
    
    // S(n) = O(n)
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int halfSize = nums.length / 2;
        for(int num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
            if(map.get(num) > halfSize)
                return num;
        }
        
        return -1;
    }
    
//	Runtime: 12 ms, faster than 24.50% of Java online submissions for Majority Element.
//	Memory Usage: 45 MB, less than 35.29% of Java online submissions for Majority Element.
}
