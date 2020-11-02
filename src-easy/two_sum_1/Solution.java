package two_sum_1;

import java.util.Arrays;
import java.util.HashMap;

//	Given an array of integers, 
//	return indices of the two numbers such that they add up to a specific target.
//
//	You may assume that each input would have exactly one solution, 
//	and you may not use the same element twice.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9))); // [0, 1]
    }
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            else
                map.put(nums[i], i);
        }
        return null;
    }
}
