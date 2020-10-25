package bag_of_tokens_948;

import java.util.Arrays;

//    You have an initial power of P, an initial score of 0, 
//    and a bag of tokens where tokens[i] is the value of the ith token (0-indexed).
//    
//    Your goal is to maximize your total score by potentially playing each token in one of two ways:
//        If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
//        If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
//        
//    Each token may be played at most once and in any order. 
//    You do not have to play all the tokens.
//
//    Return the largest possible score you can achieve after playing any number of tokens.

//    Constraints:
//        0 <= tokens.length <= 1000
//        0 <= tokens[i], P < 104

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCasesTokens = {{100}, {100, 200}, {100, 200, 300, 400}}; // 0, 1, 2
        int[] testCasesP = {50, 150, 200};
        for(int i = 0; i < testCasesTokens.length; i++) {
            System.out.println(solution.bagOfTokensScore(testCasesTokens[i], testCasesP[i]));
        }
    }
    
    public int bagOfTokensScore(int[] tokens, int P) {
        if(tokens.length == 0)
            return 0;
        if(tokens.length == 1)
            return tokens[0] <= P ? 1 : 0;
        
        Arrays.sort(tokens);
        int score = 0;
        for(int i = 0, j = tokens.length - 1; i <= j;) {
            if(P >= tokens[i]) {
                P -= tokens[i];
                score++;
                i++;
            }
            else if(score >= 1 && j - i > 1) {
                P += tokens[j];
                score--;
                j--;
            }
            else
                break;
        }
        
        return score;
    }
}

//    Runtime: 2 ms, faster than 99.75% of Java online submissions for Bag of Tokens.
//    Memory Usage: 38.6 MB, less than 8.73% of Java online submissions for Bag of Tokens.
