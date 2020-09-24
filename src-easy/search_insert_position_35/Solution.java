package search_insert_position_35;

//	Given a sorted array and a target value, return the index if the target is found. 
//	If not, return the index where it would be if it were inserted in order.
//
//	You may assume no duplicates in the array.

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {1, 3, 5, 6};
		System.out.println(solution.searchInsert(nums, 5));
	}
				
	public int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2; // can't use (l + r) / 2, because l + r could be larger than Integer.MAX_VALUE
			if(nums[m] == target)
				return m;
			else if(nums[m] > target)
				r = m - 1;
			else
				l = m + 1;
//			System.out.print("l:" + l + " m:" + m + " r:" + r + " ; ");
		}
 
		return Math.max(l, r);
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
//	Memory Usage: 39.3 MB, less than 60.58% of Java online submissions for Search Insert Position.
