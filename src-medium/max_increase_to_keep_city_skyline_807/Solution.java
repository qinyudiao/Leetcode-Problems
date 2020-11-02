package max_increase_to_keep_city_skyline_807;

import java.util.Arrays;

//	In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
//	We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings).
//	Height 0 is considered to be a building as well. 
//	At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid.
//	A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
//
//	What is the maximum total sum that the height of the buildings can be increased?

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(s.maxIncreaseKeepingSkyline(grid));
    }
    
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] skyline_tb = new int[n]; // skyline viewed from top or bottom / largest per column.
        int[] skyline_lr = new int[m]; // skyline viewed from left or right / largest per row.
        
        Arrays.fill(skyline_tb, 0);
        
        for(int i = 0; i < m; i++) {
            skyline_lr[i] = largest(grid[i]);
            for(int j = 0; j < n; j++) {
                skyline_tb[j] = Math.max(skyline_tb[j], grid[i][j]);
            }
        }
        
        int sum = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += (Math.min(skyline_lr[i], skyline_tb[j]) - grid[i][j]);
            }
        }
        
//		System.out.println(Arrays.toString(skyline_tb));
//		System.out.println(Arrays.toString(skyline_lr));
        return sum;
    }
    
    public int largest(int[] array) {
        int largest = 0;
        for(int toCompare : array) {
            if(largest < toCompare)
                largest = toCompare;
        }
        return largest;
    }
}

//	Runtime: 1 ms, faster than 99.23% of Java online submissions for Max Increase to Keep City Skyline.
//	Memory Usage: 39.7 MB, less than 40.37% of Java online submissions for Max Increase to Keep City Skyline.
