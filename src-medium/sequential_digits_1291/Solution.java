package sequential_digits_1291;

import java.util.ArrayList;
import java.util.List;

//	An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
//	
//	Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

//	Constraints:
//		10 <= low <= high <= 10^9

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{100, 300}, {1000, 13000}, {88, 234}, {10, 10000}}; // [123, 234], [1234, 2345, 4567, 5678, 6789, 12345], [89, 123, 234], [12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789]
		for(int[] testCase : testCases) {
			System.out.println(solution.sequentialDigits(testCase[0], testCase[1]));	
		}
	}

	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> result = new ArrayList<>();

		// find num of digits of low and high
		int lowDigits = 0;
		int highDigits = 0;
		for(int i = low; i != 0; i /= 10) {
			lowDigits++;
		}
		for(int i = high; i != 0; i /= 10) {
			highDigits++;
		}

		// initialize numToStart and numToAdd
		int numToStart = 1;
		int numToAdd = 1;
		for(int i = 1; i < lowDigits; i++) {
			numToStart = (numToStart * 10) + i + 1;
			numToAdd = (numToAdd * 10) + 1;
		}

		// for num of digits = lowDigits
		int num = numToStart;
		for(; num % 10 != 0; num += numToAdd) {
			if(num >= high)
				return result;
			if(num >= low)
				result.add(num);
		}

		// for num of digits in between
		for(int d = lowDigits + 1; d < highDigits; d++) {
			numToStart = (numToStart * 10) + d;
			numToAdd = (numToAdd * 10) + 1;
			num = numToStart;
			for(; num % 10 != 0; num += numToAdd) {
				result.add(num);
			}
		}

		// for num of digits = highDigits
		numToStart = (numToStart * 10) + highDigits;
			numToAdd = (numToAdd * 10) + 1;
			num = numToStart;
		for(; num % 10 != 0; num += numToAdd) {
			if(num > high)
				return result;
			result.add(num);
		}

		return result;
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Sequential Digits.
//	Memory Usage: 36.9 MB, less than 61.28% of Java online submissions for Sequential Digits.

