package pancake_sorting_969;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	Given an array of integers A, We need to sort the array performing a series of pancake flips.
//	
//	In one pancake flip we do the following steps:
//		Choose an integer k where 0 <= k < A.length.
//		Reverse the sub-array A[0...k].
//		For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse the sub-array [3,2,1], so A = [1,2,3,4] after the pancake flip at k = 2.
//	
//	Return an array of the k-values of the pancake flips that should be performed in order to sort A. 
//	Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

//	Constraints:
//		1 <= A.length <= 100
//		1 <= A[i] <= A.length
//		All integers in A are unique (i.e. A is a permutation of the integers from 1 to A.length).

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{3, 2, 4, 1}, {1, 2, 3}, {1, 2, 4, 4, 5, 6}, {1, 0, 3, 5}, {3, 1, 2, 4}}; // [3, 2, 4, 1] (3, 4, 2, 3, 2)-> [4, 2, 3, 1],
                                                                                                       // [1, 3, 2, 4], [3, 1, 2, 4], [2, 1, 3, 4],
                                                                                                       // [1, 2, 3, 4]
        for(int[] testCase : testCases) {
            System.out.println(solution.pancakeSort(testCase));
        }
        
    }
    
    // idea: find the max -> flip max to 0 -> then flip max to the end of the
    // unsorted array. The array is sorted from back to front.
    // O(n^2), where n is A.length
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int[] arr = A;
        for(int j = A.length - 1; j > 0; j--) {
            int maxIndex = maxIndex(Arrays.copyOfRange(arr, 0, j + 1));
            if(maxIndex == 0) {
                result.add(j + 1);
                arr = flipSubArrayFrom0(arr, j);
            }
            else if(maxIndex < j) {
                result.add(maxIndex + 1);
                result.add(j + 1);
                arr = flipSubArrayFrom0(arr, maxIndex);
                arr = flipSubArrayFrom0(arr, j);
            }
        }
        
        return result;
    }
    
    public int[] flipSubArrayFrom0(int[] arr, int to) {
        for(int i = 0, j = to; i < j; i++, j--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        
        return arr;
    }
    
    public int maxIndex(int[] arr) {
        int maxIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[maxIndex])
                maxIndex = i;
        }
        
        return maxIndex;
    }
}

//	Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake Sorting.
//	Memory Usage: 39.7 MB, less than 62.58% of Java online submissions for Pancake Sorting.
