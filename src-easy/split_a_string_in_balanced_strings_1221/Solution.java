package split_a_string_in_balanced_strings_1221;

//	Balanced strings are those who have equal quantity of 'L' and 'R' characters.
//	
//	Given a balanced string s split it in the maximum amount of balanced strings.
//	
//	Return the maximum amount of splitted balanced strings.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCases = {"RLRRLLRLRL", "RLLLLRRRLR", "LLLLRRRR", "RLRRRLLRLL"}; // 4, 3, 1, 2
		
		for(String testCase : testCases) {
			System.out.println(solution.balancedStringSplit(testCase));	
		}
	}
	
    public int balancedStringSplit(String s) {
        int count = 0;
        int count_L = 0, count_R = 0;
        
        for(int i = 0; i < s.length(); i += 2){
        	if(s.charAt(i) == 'L')
        		count_L ++;
        	else
        		count_R ++;
        	
        	if(s.charAt(i + 1) == 'L')
        		count_L ++;
        	else
        		count_R ++;
        	
            if(count_L == count_R){
                count++;
            }
        }
        return count;
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
//	Memory Usage: 36.8 MB, less than 98.61% of Java online submissions for Split a String in Balanced Strings.
