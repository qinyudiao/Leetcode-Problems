package bulls_and_cows_299;

import java.util.HashMap;
import java.util.Map;

//	You are playing the following Bulls and Cows game with your friend: 
//		You write down a number and ask your friend to guess what the number is. 
//		Each time your friend makes a guess, you provide a hint 
//	that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") 
//		and how many digits match the secret number but locate in the wrong position (called "cows"). 
//		Your friend will use successive guesses and hints to eventually derive the secret number.
//	
//	Write a function to return a hint according to the secret number and friend's guess, 
//	use A to indicate the bulls and B to indicate the cows. 
//	
//	Please note that both secret number and friend's guess may contain duplicate digits.

//	Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] testCasesSecret = {"1807", "1123"}; //
        String[] testCasesGuess = {"7810", "0111"};
        
        for(int i = 0; i < testCasesSecret.length; i++) {
            System.out.println(solution.getHint(testCasesSecret[i], testCasesGuess[i]));
        }
    }
    
    public String getHint(String secret, String guess) {
        Map<Character, Integer> secrets = new HashMap<>();
        Map<Character, Integer> guesses = new HashMap<>();
        for(char c = '0'; c <= '9'; c++) {
            secrets.put(c, 0);
            guesses.put(c, 0);
        }
        int bull = 0;
        int cow = 0;
        for(int i = 0; i < secret.length(); i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);
            if(secretChar == guessChar)
                bull++;
            else {
                secrets.put(secretChar, secrets.get(secretChar) + 1);
                guesses.put(guessChar, guesses.get(guessChar) + 1);
            }
        }
        
        for(char c = '0'; c <= '9'; c++) {
            cow += Math.min(secrets.get(c), guesses.get(c));
        }
        
        return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
    }
}

//	Runtime: 2 ms, faster than 95.16% of Java online submissions for Bulls and Cows.
//	Memory Usage: 39.4 MB, less than 79.84% of Java online submissions for Bulls and Cows.
