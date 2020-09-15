package house_robber_198;

//	You are a professional robber planning to rob houses along a street. 
//	Each house has a certain amount of money stashed, 
//	the only constraint stopping you from robbing each of them is
//	that adjacent houses have security system connected
//	and it will automatically contact the police
//	if two adjacent houses were broken into on the same night.
//	
//	Given a list of non-negative integers representing the amount of money of each house, 
//	determine the maximum amount of money you can rob tonight without alerting the police.

//	0 <= nums.length <= 100
//	0 <= nums[i] <= 400

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{1, 2, 3, 1}, {2, 7, 9, 3, 1}}; // 4, 12
		for(int[] testCase : testCases) {
			System.out.println(solution.rob(testCase));	
		}
	}

	// Idea: use an array for dynamic programming
	// T(n) = O(n)
	// S(n) = O(n)
	// trade off: faster runtime, more memory
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		
        int[] results = new int[nums.length];
		results[0] = nums[0];
		results[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
        	results[i] = Math.max(results[i-2] + nums[i], results[i-1]);
        }
        
        return results[nums.length-1];
    }
	
	// T(n) = O(3n)
	// S(n) = O(1)
	// trade off: less memory, slower runtime
	public int rob1(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		
        int last2 = nums[0];
        int last1 = Math.max(nums[0], nums[1]);
        int temp;
        for(int i = 2; i < nums.length; i++) {
        	temp = last1;
        	last1 = Math.max(last2 + nums[i], last1);
        	last2 = temp;
        }
        
        return last1;
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
//	Memory Usage: 36.7 MB, less than 82.10% of Java online submissions for House Robber.
