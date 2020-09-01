package largest_time_for_given_digits_949;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//	Given an array of 4 digits, return the largest 24 hour time that can be made.
//	
//	The smallest 24 hour time is 00:00, and the largest is 23:59. 
//	Starting from 00:00, a time is larger if more time has elapsed since midnight.
//	
//	Return the answer as a string of length 5. 
//	If no valid time can be made, return an empty string.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCases = {{2, 1, 3, 4}, {5, 5, 5, 5}, {2, 3, 4, 5}, {2, 2, 3, 5}, {2, 2, 3, 3}, {1, 2, 2, 5}, {2, 0, 6, 6}, // "23:41", "", "23:54", "23:52", "23:32", "22:51", "06:26"
				{0, 1, 0, 3}, {2, 0, 5, 3}, {0, 9, 9, 5}, {0, 6, 6, 6}, {0, 0, 1, 0}, {0, 0, 0, 2}, {2, 3, 7, 9}}; //"13:10", "23:50", "09:59", "", "10:00", "20:00", ""
		for(int[] testCase : testCases) {
			System.out.println(solution.largestTimeFromDigits(testCase));
		}
	}
	
	// Using StringBuilder is faster than String concat
	public String largestTimeFromDigits(int[] A) {
		StringBuilder result = new StringBuilder();
		
		List<Integer> digits = new ArrayList<>(4);
		for(int digit : A) {
			digits.add(digit);
		}
		Collections.sort(digits);
		
		if(digits.get(0) > 2)
			return "";
		else if(digits.get(0) == 2) {
			if(digits.get(1) > 3)
				return "";
			else if(digits.get(2) > 3) {
				result.append(2);
				result.append(digits.get(1));
				result.append(":");
				digits.remove(1);
				digits.remove(0);
			}
			else if(digits.get(3) > 3) {
				result.append(2);
				result.append(digits.get(2));
				result.append(":");
				digits.remove(2);
				digits.remove(0);
			}
			else {
				result.append(2);
				result.append(digits.get(3));
				result.append(":");
				digits.remove(3);
				digits.remove(0);
			}
		}
		else {
			if(digits.get(1) == 2 && digits.get(2) > 5) {
				result.append(digits.get(0));
				result.append(digits.get(3));
				result.append(":");
				digits.remove(3);
				digits.remove(0);
			}
			else if(digits.get(0) == 1) {
				if(digits.contains(2)) {
					result.append(2);
					digits.remove(new Integer(2));
					int digit2 = 1;
					for(int digit : digits) {
						if(digit < 4 && digit > digit2)
							digit2 = digit;
					}
					digits.remove(new Integer(digit2));
					result.append(digit2);
					result.append(":");
				}
				else {
					digits.remove(0);
					result.append(1);
					result.append(digits.get(2));
					result.append(":");
					digits.remove(2);
				}
			}
			else if(digits.get(0) == 0) {
				if(digits.contains(2)) {
					result.append(2);
					digits.remove(new Integer(2));
					int digit2 = 0;
					for(int digit : digits) {
						if(digit < 4 && digit > digit2)
							digit2 = digit;
					}
					digits.remove(new Integer(digit2));
					result.append(digit2);
					result.append(":");
				}
				else if(digits.contains(1)){
					digits.remove(new Integer(1));
					result.append(1);
					result.append(digits.get(2));
					result.append(":");
					digits.remove(2);
				}
				else {
					result.append(0);
					result.append(digits.get(3));
					result.append(":");
					digits.remove(3);
					digits.remove(0);
				}
			}
		}
		
		if(digits.get(0) > 5)
			return "";
		else if(digits.get(1) < 6) {
			result.append(digits.get(1));
			result.append(digits.get(0));
		}
		else {
			result.append(digits.get(0));
			result.append(digits.get(1));
		}
		
		return result.toString();
    }
}

//	Runtime: 2 ms, faster than 93.49% of Java online submissions for Largest Time for Given Digits.
//	Memory Usage: 37 MB, less than 99.43% of Java online submissions for Largest Time for Given Digits.
