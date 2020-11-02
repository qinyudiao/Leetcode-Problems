package maximum_subarray_53;

//	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//	
//	Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{-2, 1, -3, 4, -1, 2, 1, -5, 4}, {1}, {0}, {-1}, {-2147483647}}; // 6, 1, 0, -1, -2147483647
        for(int[] testCase : testCases) {
            System.out.println(solution.maxSubArray1(testCase));
        }
    }
    
    // T(n) = O(n)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > max)
                max = sum;
        }
        
        return max;
    }
    
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum
    // Subarray.
    // Memory Usage: 39.3 MB, less than 76.45% of Java online submissions for
    // Maximum Subarray.
    
    // Idea: divide and conquer
    // T(n) = O(n*logn)
    public int maxSubArray1(int[] nums) {
        return maxSubArrayDAC(0, nums.length, nums)[0];
    }
    
    private int[] maxSubArrayDAC(int left, int right, int[] nums) { // returns [max, maxStart, maxEnd, sum]
        if(right - left == 1)
            return new int[] {nums[left], nums[left], nums[left], nums[left]};
        
        int[] valsLeft = maxSubArrayDAC(left, (right + left) / 2, nums);
        int[] valsRight = maxSubArrayDAC((right + left) / 2, right, nums);
        
        int max = Math.max(Math.max(valsLeft[0], valsRight[0]), valsLeft[2] + valsRight[1]);
        int maxStart = Math.max(valsLeft[1], valsLeft[3] + valsRight[1]);
        int maxEnd = Math.max(valsRight[2], valsRight[3] + valsLeft[2]);
        int sum = valsLeft[3] + valsRight[3];
        
        return new int[] {max, maxStart, maxEnd, sum};
    }
    
    // Runtime: 1 ms, faster than 72.01% of Java online submissions for Maximum
    // Subarray.
    // Memory Usage: 39.8 MB, less than 33.52% of Java online submissions for
    // Maximum Subarray.
}
