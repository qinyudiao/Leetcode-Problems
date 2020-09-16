package length_of_last_word_58;

//	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
//	return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
//	
//	If the last word does not exist, return 0.
//	
//	Note: A word is defined as a maximal substring consisting of non-space characters only.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCases = {"Hello World", "world", "", " ", "a "}; // 5, 5, 0, 0
		for(String testCase : testCases) {
			System.out.println(solution.lengthOfLastWord(testCase));
		}
	}
	
	public int lengthOfLastWord(String s) {
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
        	if(s.charAt(i) == ' ' && length == 0)
        		continue;
        	else if(s.charAt(i) == ' ')
        		break;
        	else
        		length++;
        }
        
        return length;
    }
}
