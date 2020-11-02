package binary_search_704;

/**
 * @author diaoqinyu
 *
 */

//    Given a sorted (in ascending order) integer array nums of n elements and a target value, 
//    write a function to search target in nums. 
//    If target exists, then return its index, otherwise return -1.

//    Note:
//        1. You may assume that all elements in nums are unique.
//        2. n will be in the range [1, 10000].
//        3. The value of each element in nums will be in the range [-9999, 9999].

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCasesNums = {{-1, 0, 3, 5, 9, 12}, {-1, 0, 3, 5, 9, 12}, {2, 5}, {-1, 0, 3, 5, 9, 12}, {-1, 0, 3, 5, 9, 12}, {5}}; // 4, -1, 0, 2,
                                                                                                                                       // -1, 0
        int[] testCasesTargets = {9, 2, 2, 3, 13, 5};
        for(int i = 0; i < testCasesNums.length; i++) {
            System.out.println(solution.search(testCasesNums[i], testCasesTargets[i]));
        }
    }
    
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        
        int l = 0;
        int r = nums.length;
        int m = -1;
        while(m != (l + r) / 2) {
            m = (l + r) / 2;
            if(nums[m] < target)
                l = m;
            else if(nums[m] > target)
                r = m;
            else
                return m;
        }
        
        return -1;
    }
}

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
//    Memory Usage: 39.7 MB, less than 96.67% of Java online submissions for Binary Search.
