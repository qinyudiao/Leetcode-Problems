package contains_duplicate_II_219;

import java.util.HashMap;

//	Given an array of integers and an integer k, 
//	find out whether there are two distinct indices i and j in the array 
//	such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCasesNums = {{1, 2, 3, 1}, {1, 0, 1, 1}, {1, 2, 3, 1, 2, 3}}; // true, true, false
		int[] testCasesK = {3, 1, 2};
		for(int i = 0; i < testCasesNums.length; i++) {
			System.out.println(solution.containsNearbyDuplicate(testCasesNums[i], testCasesK[i]));
		}

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
				return true;
			}
			else
				map.put(nums[i], i);
		}
		
        return false;
    }
}
