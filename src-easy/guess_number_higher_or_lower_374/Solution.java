package guess_number_higher_or_lower_374;

//	We are playing the Guess Game. The game is as follows:
//
//	I pick a number from 1 to n. You have to guess which number I picked.
//
//	Every time you guess wrong, I'll tell you whether the number is higher or lower.
//
//	You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
//
//	-1 : My number is lower
//	 1 : My number is higher
//	 0 : Congrats! You got it!

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class GuessGame {
	private int guessedNumber = 6;
	
	int guess(int n) {
		if(n == guessedNumber)
			return 0;
		else if(n < guessedNumber)
			return 1;
		else
			return -1;
	}
	
	protected void setGuessedNumber(int n) {
		this.guessedNumber = n;
	}
}

public class Solution extends GuessGame {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] testCases = { { 1, 1 }, { 6, 10 }, { 8, 10 }, { 2, 10 }, { 55, 100 }, { 177, 177 }, {222123, 321312}, {1702766719, 2126753390}, {2147483647, 2147483647}}; // {guessedNumber, n}
		
		for(int[] testCase : testCases) {
			solution.setGuessedNumber(testCase[0]);
			System.out.println(" ------ " + solution.guessNumber(testCase[1]));	
		}
	}
	
	// T(n) = O(log n)
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
        	int toGuess = l + (r - l) / 2; // can't use (l + r) / 2, because l + r could be larger than Integer.MAX_VALUE
        	int guessedResult = guess(toGuess);
        	
        	if(guessedResult == 0)
        		return toGuess;
        	else if(guessedResult == 1) {
        		l = toGuess + 1;
        	} else {
        		r = toGuess - 1;
        	}
//        	System.out.print("l: " + l + " r: " + r + " ; ");
        }
 
        return -1;
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
//	Memory Usage: 36.2 MB, less than 67.62% of Java online submissions for Guess Number Higher or Lower.
