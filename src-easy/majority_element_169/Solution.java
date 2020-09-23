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

	public int majorityElement(int[] nums) {
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
}
