package sort_array_by_parity_905;

import java.util.Arrays;

//	Given an array A of non-negative integers, 
//	return an array consisting of all the even elements of A, 
//	followed by all the odd elements of A.
//	
//	You may return any answer array that satisfies this condition.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{3, 1, 2, 4}, {1, 2, 3, 4, 5, 6}, {1, 2, 4}, {1, 0 ,3 ,5}, {3, 1, 2, 4}};
		for(int[] testCase : testCases) {
			System.out.println(Arrays.toString(solution.sortArrayByParity(testCase)));	
		}
	}
	
	public int[] sortArrayByParity(int[] A) {
		for(int i = 0, offset = 0, n = A.length - 1; i - offset < n; i++) {
//			System.out.print("i: " + i + " ");
//			System.out.print("offset: " + offset + " ");
			if(A[i-offset] % 2 != 0) { // if current number is odd, switch with the rightmost number that has not been switched yet
				int temp = A[i-offset];
				A[i-offset] = A[n];
				if(A[n] % 2 != 0) // if switched number is also odd, add offset to switch it again
					offset++;
				A[n] = temp;
				n--; // update the index of the rightmost number that has not been switched yet
			}
			
//			System.out.println(Arrays.toString(A));
		}
		return A;
	}
}

//	Runtime: 1 ms, faster than 99.69% of Java online submissions for Sort Array By Parity.
//	Memory Usage: 40.5 MB, less than 52.58% of Java online submissions for Sort Array By Parity.
