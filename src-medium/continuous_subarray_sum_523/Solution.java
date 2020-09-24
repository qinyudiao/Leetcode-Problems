package continuous_subarray_sum_523;

import java.util.HashMap;
import java.util.Map;

//	Given a list of non-negative numbers and a target integer k, 
//	write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, 
//	that is, sums up to n*k where n is also an integer.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6)); // True [0, 5]
		System.out.println(solution.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 3)); // True [1, 3]
		System.out.println(solution.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 5)); // True [0, 2]
		System.out.println(solution.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 15)); // False
		System.out.println(solution.checkSubarraySum(new int[] {0, 0}, 0)); // True
	}
	
	// use HashMap to save time
	public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0)
				sum = sum % k;
			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1)
					return true;
			}
			else
				map.put(sum, i);
		}
		
		return false;
	}
	
	// dp[n] // n is the end index
	public boolean checkSubarraySum1(int[] nums, int k) {
		int n = nums.length;
		int[] dp = new int[n+1];

		dp[1] = nums[0];
		for(int l = 2; l <= n; l++) {
			for(int i = l; i <= n; i++) {
				dp[i] = (i == l) ? dp[i-1] + nums[i-1] : dp[i-1] + nums[i-1] - nums[i-l-1];
	//        		System.out.print(dp[i] + " ");
	//        		System.out.print(i + " ");
				if(k == 0) {
					if(dp[i] == 0) {
						System.out.print(i - l + ", " + i + " ");
						return true;
					}
				}
				else if(dp[i] % k == 0) {
					System.out.print(i - l + ", " + i + " ");
					return true;
				}
			}
		}
		return false;
	}

	// works, but memory limit exceeded;
	public boolean checkSubarraySum2(int[] nums, int k) {
		int n = nums.length;
		int[][] dp = new int[n][n+1];

		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j <= n; j++) {
				dp[i][j] = dp[i][j-1] + nums[j-1];
				if(j - i >= 2) {
					if(k == 0) {
						if(dp[i][j] == 0)
							return true;
					}
					else if(dp[i][j] % k == 0) {
						System.out.print(i + ", " + j + " ");
						return true;
					}
				}
			}
		}
		return false;
	}
}
