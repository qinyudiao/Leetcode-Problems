package unique_paths_III_980;

//	On a 2-dimensional grid, there are 4 types of squares:
//		1 represents the starting square.  There is exactly one starting square.
//		2 represents the ending square.  There is exactly one ending square.
//		0 represents empty squares we can walk over.
//		-1 represents obstacles that we cannot walk over.
//	Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

//	Note: 1 <= grid.length * grid[0].length <= 20

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][][] testCases = {{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}, {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}, {{0, 1}, {2, 0}}}; // 2, 4, 0
        for(int[][] testCase : testCases) {
            System.out.println(solution.uniquePathsIII(testCase));
        }
    }
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int numEmpties = 0;
        int startI = 0, startJ = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0)
                    numEmpties++;
                else if(grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }
        
        return dfs(startI, startJ, numEmpties, grid);
    }
    
    private int dfs(int i, int j, int numEmpties, int[][] grid) {
        if(grid[i][j] == 2)
            return numEmpties == -1 ? 1 : 0;
        
        grid[i][j] = -1; // mark it as visited
        numEmpties--;
        
        int count = 0;
        if(i >= 1 && grid[i - 1][j] != -1) // top
            count += dfs(i - 1, j, numEmpties, grid);
        if(i < grid.length - 1 && grid[i + 1][j] != -1) // bottom
            count += dfs(i + 1, j, numEmpties, grid);
        if(j >= 1 && grid[i][j - 1] != -1) // left
            count += dfs(i, j - 1, numEmpties, grid);
        if(j < grid[0].length - 1 && grid[i][j + 1] != -1) // right
            count += dfs(i, j + 1, numEmpties, grid);
        
        grid[i][j] = 0;
        
        return count;
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths III.
//	Memory Usage: 36.5 MB, less than 93.97% of Java online submissions for Unique Paths III.
