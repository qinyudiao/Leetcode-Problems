package non_decreasing_array_665;

//	Given an array nums with n integers, 
//	your task is to check if it could become non-decreasing by modifying at most 1 element.
//
//	We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1, 3, 2, 2, 2};
		System.out.println(s.checkPossibility(nums));
	}
	
	public boolean checkPossibility(int[] nums) {
		int i = 1;
		while(i<nums.length) {
			if(nums[i]>=nums[i-1])
				i++;
			else
				break;
		}
		
//		System.out.print(i);
		
		if(i>=nums.length-1) // == for already non-decreasing array, > for length 1.
			return true;
		else if(i>1 && nums[i]<nums[i-2] && nums[i+1]<nums[i-1]) // [3, 8, 2, 7]
			return false;
		else if(nums[i+1]<Math.min(nums[i-1], nums[i]))
			return false;
		else
			i+=2;
		
//		System.out.print(i);
		while(i<nums.length) {
			if(nums[i]>=nums[i-1])
				i++;
			else
				return false;
		}
		
		return true;
	}
}
