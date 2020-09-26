package largest_number_179;

import java.util.Arrays;
import java.util.Comparator;

//	Given a list of non negative integers, arrange them such that they form the largest number.

//	Note: The result may be very large, so you need to return a string instead of an integer.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCases = {{10, 2}, {3, 30, 34, 5, 9}, {3, 33, 331, 30, 39}, {0, 0}, {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}, {121, 12}}; // 210, 9534330, 3933333130, 0, 9609938824824769735703560743981399, 12121
		for(int[] testCase : testCases) {
			System.out.println(solution.largestNumber(testCase));	
		}
	}

	// Idea: Compare two integers by checking which concatenation of the them is larger.
	// T(n) = O(nlogn), where n is the length of nums.
	// T(n) = O(n)
	public String largestNumber(int[] nums) {
		String[] numStrs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			numStrs[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(numStrs, (s1, s2) -> {
			return (s2 + s1).compareTo(s1 + s2); // no need for StringBuilder beacuse only one concatenation meaning that only one object is created.
		});

		if(numStrs[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for(String numStr : numStrs) {
			sb.append(numStr);
		}

		return sb.toString();
	}

	//	Runtime: 4 ms, faster than 98.32% of Java online submissions for Largest Number.
	//	Memory Usage: 38.1 MB, less than 99.31% of Java online submissions for Largest Number.

	// Idea: Compare two integers by recursively comparing the remnant of the longer string and the shorter string.
	// It has the same runtime and memory usage as the above approach.
	// T(n) = O(nlogn), where n is the length of nums.
	// T(n) = O(n)
	public String largestNumber1(int[] nums) {
		String[] numStrs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			numStrs[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(numStrs, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length())
					return compareIntFromStrWithSameLength(s1, s2);
				else if(s1.length() > s2.length())
					return compareIntFromStrWithDifferentLength(s1, s2);
				else
					return - compareIntFromStrWithDifferentLength(s2, s1);
			}

			private int compareIntFromStrWithSameLength(String s1, String s2) {
				int n1 = Integer.parseInt(s1);
				int n2 = Integer.parseInt(s2);
				if(n1 > n2)
					return -1;
				else if(n1 < n2)
					return 1;
				else
					return 0;
			}

			private int compareIntFromStrWithDifferentLength(String s1, String s2) {
				if(s1.substring(0, s2.length()).equals(s2)) {
					char[] s1Tail = s1.substring(s2.length()).toCharArray();
					char s2FirstDigit = s2.charAt(0);
					for(char digit : s1Tail) {
						if(digit > s2FirstDigit)
							return -1;
						else if(digit < s2FirstDigit)
							return 1;
					}

					return compare(s1.substring(s2.length()), s2);
				}
				else
					return compareIntFromStrWithSameLength(s1.substring(0, s2.length()), s2);
			}

		});

		if(numStrs[0].equals("0"))
			return "0";

		StringBuilder sb = new StringBuilder();
		for(String numStr : numStrs) {
			sb.append(numStr);
		}

		return sb.toString();
	}

	//	Runtime: 4 ms, faster than 98.32% of Java online submissions for Largest Number.
	//	Memory Usage: 38 MB, less than 99.38% of Java online submissions for Largest Number.
}
