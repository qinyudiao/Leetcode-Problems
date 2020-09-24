package find_pivot_index_724;

//	Given an array of integers nums, 
//	write a method that returns the "pivot" index of this array.
//	
//	We define the pivot index as the index 
//	where the sum of all the numbers to the left of the index is equal to 
//	the sum of all the numbers to the right of the index.
//	
//	If no such index exists, we should return -1. 
//	If there are multiple pivot indexes, 
//	you should return the left-most pivot index.
		
public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{1,7,3,6,5,6}, {1,2,3}}; // 3, -1
		
		for(int[] testCase : testCases) {
			System.out.println(solution.pivotIndex(testCase));	
		}
	}
	
	public int pivotIndex(int[] nums) {
		if(nums.length < 3)
			return -1;
        
		int sum_left = 0;
		int sum_right = 0;
        
		for(int i=1; i<nums.length; i++) {
			sum_right += nums[i];
		}
        
		if((sum_right) == 0)
			return 0;

		int index = 1;
		while(index < nums.length) {
			sum_left += nums[index-1];
			sum_right -= nums[index];
			if(sum_left == sum_right)
				return index;
			index++;
		}
		
		return -1;
	}
}

//	Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Pivot Index.
//	Memory Usage: 40.4 MB, less than 45.26% of Java online submissions for Find Pivot Index.
