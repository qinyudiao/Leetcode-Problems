package contains_duplicate_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//	Given an array of integers, find if the array contains any duplicates.
//	
//	Your function should return true if any value appears at least twice in the array, 
//	and it should return false if every element is distinct.
		
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCases = {{1, 2, 3, 1}, {1, 2, 3, 4}, {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}}; // true, false, true
		for(int[] testCase : testCases) {
			System.out.println(solution.containsDuplicate(testCase));
		}
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		
		for(int num : nums) {
			if(set.contains(num))
				return true;
			else
				set.add(num);
		}
		
		return false;
	}
	
	public boolean containsDuplicate1(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1])
				return true;
		}
		
		return false;
	}
}
