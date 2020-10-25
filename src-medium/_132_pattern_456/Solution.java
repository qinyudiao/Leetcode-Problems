package _132_pattern_456;

import java.util.Stack;

//    Given an array of n integers nums, 
//    a 132 pattern is a subsequence of three integers nums[i], 
//    nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
//    
//    Return true if there is a 132 pattern in nums, otherwise, return false.
//
//    Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?

//    Constraints:
//        n == nums.length
//        1 <= n <= 104
//        -109 <= nums[i] <= 109

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int testCases[][] = {{1, 2, 3, 4}, {3, 1, 4, 2}, {-1, 3, 2, 0}, {1, 4, 0, 3}, {1, 4, 0, 1}}; // false, true, true, true, false
        for(int[] testCase : testCases) {
            System.out.println(solution.find132pattern(testCase));
        }
    }

    public boolean find132pattern(int[] nums) {
        if(nums.length < 3)
            return false;

        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for(int i = 1; i < mins.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > mins[i]) {
                while(!stack.empty() && stack.peek() <= mins[i]) {
                    stack.pop();
                }
                if(!stack.empty() && stack.peek() < nums[i])
                    return true;
                stack.push(nums[i]);
            }
        }

        return false;
    }
}
