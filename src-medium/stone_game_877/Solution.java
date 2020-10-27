package stone_game_877;

//    Alex and Lee play a game with piles of stones. 
//    There are an even number of piles arranged in a row, 
//    and each pile has a positive integer number of stones piles[i].
//    
//    The objective of the game is to end with the most stones. 
//    The total number of stones is odd, so there are no ties.
//    
//    Alex and Lee take turns, with Alex starting first. 
//    Each turn, a player takes the entire pile of stones from either the beginning or the end of the row. 
//    This continues until there are no more piles left, at which point the person with the most stones wins.
//    
//    Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

//    Constraints:
//        2 <= piles.length <= 500
//        piles.length is even.
//        1 <= piles[i] <= 500
//        sum(piles) is odd.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{5, 3, 4, 5}, {1, 2, 3, 4}, {3, 1, 4, 2}, {1, 8}, {1, 9, 2, 5, 1, 1}}; // 1 true, 2 true, 4 true, 7 true, 11 true
        for(int[] testCase : testCases) {
            System.out.println(solution.stoneGame(testCase));
        }
    }
    
    public boolean stoneGame(int[] piles) {
        int dp[][] = new int[piles.length][piles.length];
        
        for(int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        
        for(int j = 1; j < dp.length; j++) {
            for(int i = 0; i + j < dp.length; i++) {
                dp[i][i + j] = Math.max(piles[i] - dp[i + 1][i + j], piles[i + j] - dp[i][i + j - 1]);
            }
        }
        
//        System.out.println(dp[0][dp.length - 1]);
        return dp[0][dp.length - 1] > 0;
    }
}
