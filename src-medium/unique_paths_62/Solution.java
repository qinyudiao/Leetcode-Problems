package unique_paths_62;

import java.util.Arrays;

//	A robot is located at the top-left corner of a m x n grid.
//	
//	The robot can only move either down or right at any point in time.
//	The robot is trying to reach the bottom-right corner of the grid.
//	
//	How many possible unique paths are there?

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{3, 7}, {3, 2}, {7, 3}, {3, 3}}; // 28, 3, 28, 6
		for(int[] testCase : testCases) {
			System.out.println(solution.uniquePaths(testCase[0], testCase[1]));	
		}
	}

	// Idea: Use 2d array to store the unique paths to each grid. The number of unique paths to each grid is the sum of the left grid and top grid.
	// T(n) = O(m*n)
	// S(n) = O(m*n)
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for(int[] row : dp) {
			row[0] = 1;
		}
		for(int j = 1; j < n; j++) {
			dp[0][j] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
			dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}

		System.out.println(Arrays.deepToString(dp));

		return dp[m-1][n-1];
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
//	Memory Usage: 35.9 MB, less than 95.81% of Java online submissions for Unique Paths.
