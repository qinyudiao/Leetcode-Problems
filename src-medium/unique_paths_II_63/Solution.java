package unique_paths_II_63;

import java.util.Arrays;

//	A robot is located at the top-left corner of a m x n grid.
//	
//	The robot can only move either down or right at any point in time. 
//	The robot is trying to reach the bottom-right corner of the grid.
//	
//	Now consider if some obstacles are added to the grids. How many unique paths would there be?

//	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//	
//	Note: m and n will be at most 100.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][][] testCases = {{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, {{1, 0}, {1, 0}}}; // 2, 0
		for(int[][] testCase : testCases) {
			System.out.println(solution.uniquePathsWithObstacles(testCase));	
		}
	}

	// Idea:
	//		Use 2d array to store the unique paths to each grid. 
	// 		The number of unique paths to each grid is the sum of the left grid and top grid.
	//		If there is an obstacle at this grid, then it is 0.
	// T(n) = O(m*n)
	// S(n) = O(m*n)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i++) {
			if(obstacleGrid[i][0] > 0)
				break;
			dp[i][0] = 1;
		}
		for(int j = 0; j < n; j++) {
			if(obstacleGrid[0][j] > 0)
				break;
			dp[0][j] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] > 0)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
			}
		}

		System.out.println(Arrays.deepToString(dp));
        
		return dp[m-1][n-1];
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
//	Memory Usage: 37.4 MB, less than 93.47% of Java online submissions for Unique Paths II.
