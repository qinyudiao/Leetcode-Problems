package minimum_absolute_diiference_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	Given an array of distinct integers arr, 
//	find all pairs of elements with the minimum absolute difference of any two elements. 
//	
//	Return a list of pairs in ascending order(with respect to pairs), 
//	each pair [a, b] follows
//	
//		a, b are from arr
//		a < b
//		b - a equals to the minimum absolute difference of any two elements in arr

//	Constraints:
//		2 <= arr.length <= 10^5
//		-10^6 <= arr[i] <= 10^6

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{4, 2, 1, 3}, {1, 3, 6, 10, 15}, {3, 8, -10, 23, 19, -4, -14, 27}}; // [[1, 2], [2, 3], [3, 4]], [[1, 3]], [[-14, -10], [19, 23], [23, 27]]
		
		for(int[] testCase : testCases) {
			System.out.println(solution.minimumAbsDifference(testCase));	
		}
	}
	
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(arr); // parallelSort by slower in leetcode judging

		List<Integer> indices = new ArrayList<>();
		int minDiff = arr[1] - arr[0];
		for(int i = 0; i < arr.length - 1; i++) {
			int curDiff = arr[i + 1] - arr[i];
			if(minDiff == curDiff)
				indices.add(i);
			else if(minDiff > curDiff) {
				indices.clear();
				minDiff = curDiff;
				indices.add(i);
			}
		}

		for(int index: indices) {
			result.add(new ArrayList<Integer>(Arrays.asList(arr[index], arr[index + 1])));
		}

		return result;
	}
}

//	Runtime: 14 ms, faster than 98.85% of Java online submissions for Minimum Absolute Difference.
//	Memory Usage: 50.3 MB, less than 84.95% of Java online submissions for Minimum Absolute Difference.
