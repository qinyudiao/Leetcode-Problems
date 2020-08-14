package cells_with_odd_values_in_a_matrix_1252;

//import java.util.Arrays;

//	Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. 
//	For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
//
//	Return the number of cells with odd values in the matrix after applying the increment to all indices.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.oddCells(2, 3, new int[][] {{0, 1}, {1, 1}}));
	}
	
	public int oddCells(int n, int m, int[][] indices) {
		int[][] matrix =  new int[n][m];
		
        for(int[] index : indices) {
        	for(int i = 0; i < matrix[index[0]].length; i++) {
        		matrix[index[0]][i]++;
        	}
        	for(int[] row: matrix) {
        		row[index[1]]++;
        	}
        }
        
//        for(int[] row : matrix) {
//        	 System.out.println(Arrays.toString(row));
//        }
		
		int count = 0;
        
        for(int[] row : matrix) {
        	for(int i : row) {
        		if((i % 2) == 1)
        			count++;
        	}
        }
        
        return count;
    }
}

//	Runtime: 1 ms, faster than 90.29% of Java online submissions for Cells with Odd Values in a Matrix.
//	Memory Usage: 37.7 MB, less than 55.99% of Java online submissions for Cells with Odd Values in a Matrix.