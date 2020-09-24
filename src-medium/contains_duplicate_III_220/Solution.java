package contains_duplicate_III_220;

import java.util.TreeSet;

//	Given an array of integers, 
//	find out whether there are two distinct indices i and j in the array 
//	such that the absolute difference between nums[i] and nums[j] is at most t 
//	and the absolute difference between i and j is at most k.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCasesNums = {{1, 2, 3, 1}, {1, 0, 1, 1}, {1, 5, 9, 1, 5, 9}, {-2147483648, -2147483647}, {1, 2}}; // true, true, false, true, false
		int[] testCasesK = {3, 1, 2, 3, 0};
		int[] testCasesT = {0, 2, 3, 3, 1};
		for(int i = 0; i < testCasesNums.length; i++) {
			System.out.println(solution.containsNearbyAlmostDuplicate(testCasesNums[i], testCasesK[i], testCasesT[i]));
		}
	}
	
	// O(n * log(k))
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		int i = 0;
		while(i < nums.length) {
			Long floor = set.floor((long) nums[i]); // O(log(k))
			Long ceiling = set.ceiling((long) nums[i]); // O(log(k))
			if((floor != null && nums[i] - floor <= t) || (ceiling != null && ceiling - nums[i] <= t))
				return true;
			set.add((long) nums[i++]); // O(log(k))
			if(i > k)
				set.remove((long) nums[i - k -1]); // O(log(k))
		}
		
		return false;
	}

	// O(n * k)
	public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
		int halfIntMax = Integer.MAX_VALUE / 2;
		int halfIntMin = Integer.MIN_VALUE / 2;
		for(int i = 0; i < nums.length; i++) {
			int numMax = (halfIntMax - nums[i]/2) >= t/2 ? nums[i] + t : Integer.MAX_VALUE;
			int numMin = (nums[i]/2 - halfIntMin) >= t/2 ? nums[i] - t : Integer.MIN_VALUE;
			for(int j = i + 1; j < nums.length && j <= i + k; j++) {
				if(nums[j] >= numMin && nums[j] <= numMax)
					return true;
			}
		}
		
		return false;
	}
}
