package house_robber_II_213;

//	You are a professional robber planning to rob houses along a street. 
//	Each house has a certain amount of money stashed.
//	All houses at this place are arranged in a circle. 
//	That means the first house is the neighbor of the last one. 
//	Meanwhile, adjacent houses have security system connected 
//	and it will automatically contact the police 
//	if two adjacent houses were broken into on the same night.
//
//	Given a list of non-negative integers representing the amount of money of each house, 
//	determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{2, 3, 2}, {1, 2, 3, 1}, {1, 2, 1, 1}, {1, 3, 1, 3, 100}}; // 3, 4, 3, 103
		for(int[] testCase : testCases) {
			System.out.println(solution.rob(testCase));	
		}
	}

	// Idea: dynamic programming
	// T(n) = O(n)
	// S(n) = O(n)
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		if(nums.length == 2)
			return Math.max(nums[0], nums[1]);
		
		int[] resultsNotRobbingLast = new int[nums.length-1];
		resultsNotRobbingLast[0] = nums[0];
		resultsNotRobbingLast[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < resultsNotRobbingLast.length; i++) {
			resultsNotRobbingLast[i] = Math.max(resultsNotRobbingLast[i-2] + nums[i], resultsNotRobbingLast[i-1]);
		}
		
		int[] resultsNotRobbingFirst = new int[nums.length-1];
		resultsNotRobbingFirst[0] = nums[1];
		resultsNotRobbingFirst[1] = Math.max(nums[1], nums[2]);
		for(int i = 2; i < resultsNotRobbingFirst.length; i++) {
			resultsNotRobbingFirst[i] = Math.max(resultsNotRobbingFirst[i-2] + nums[i+1], resultsNotRobbingFirst[i-1]);
		}
        
		return Math.max(resultsNotRobbingLast[resultsNotRobbingLast.length-1], resultsNotRobbingFirst[resultsNotRobbingFirst.length-1]);
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
//	Memory Usage: 36.5 MB, less than 96.52% of Java online submissions for House Robber II.
