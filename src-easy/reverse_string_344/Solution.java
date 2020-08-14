package reverse_string_344;

//	Write a function that reverses a string. 
//	The input string is given as an array of characters char[].
//	
//	Do not allocate extra space for another array, 
//	you must do this by modifying the input array in-place with O(1) extra memory.
//	
//	You may assume all the characters consist of printable ascii characters.

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		char[][] testCases = {{'h','e','l','l','o'}, {'H','a','n','n','a','h'}}; // ['o','l','l','e','h'], ['h','a','n','n','a','H']
		
		for(char[] testCase : testCases) {
			solution.reverseString(testCase);
			System.out.println(testCase);	
		}
	}
	
	public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len/2; i++) {
            char temp = s[i];
            s[i] = s[len -1 - i];
            s[len -1 -i] = temp;
        }
    }
}

//	Runtime: 1 ms, faster than 74.42% of Java online submissions for Reverse String.
//	Memory Usage: 46.2 MB, less than 77.26% of Java online submissions for Reverse String.
