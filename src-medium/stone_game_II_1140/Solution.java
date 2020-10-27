package stone_game_II_1140;

//    Alex and Lee continue their games with piles of stones. 
//    There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. 
//    The objective of the game is to end with the most stones. 
//    
//    Alex and Lee take turns, with Alex starting first. Initially, M = 1.
//    
//    On each player's turn, that player can take all the stones in the first X remaining piles, 
//    where 1 <= X <= 2M.  Then, we set M = max(M, X).
//    
//    The game continues until all the stones have been taken.
//    
//    Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.

//    Constraints:
//        1 <= piles.length <= 100
//        1 <= piles[i] <= 10 ^ 4

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{2, 7, 9, 4, 4}, {5, 3, 4, 5}, {1, 2, 3, 4}, {6}}; // 10, 10, 5
        for(int[] testCase : testCases) {
            System.out.println(solution.stoneGameII(testCase));
        }
    }
    
    public int stoneGameII(int[] piles) {
        // Calculate the sum of the remaining piles
        int[] sums = new int[piles.length];
        sums[piles.length - 1] = piles[piles.length - 1];
        for(int i = piles.length - 2; i >= 0; i--) {
            sums[i] = piles[i] + sums[i + 1];
        }
        
        if(sums.length <= 2)
            return sums[0];
        
        int[][] dp = new int[sums.length][(sums.length + 1) / 2 + 1];
        
        for(int i = sums.length - 1; i >= 0; i--) {
            int sum = sums[i];
            int m = (sums.length - i + 1) / 2;
            dp[i][m] = sum;
            while(m > 1) {
                m--;
                dp[i][m] = 0;
                for(int x = 1; x <= m * 2 && i + x < sums.length; x++) {
                    int mx = Math.min((sums.length - i - x + 1) / 2, Math.max(x, m));
                    dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][mx]);
                }
            }
        }
        
        return dp[0][1];
    }
}
