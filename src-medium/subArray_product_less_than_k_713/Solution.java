package subArray_product_less_than_k_713;

//    Your are given an array of positive integers nums.
//    
//    Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

//    Note:
//        0 < nums.length <= 50000.
//        0 < nums[i] < 1000.
//        0 <= k < 10^6.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCasesNums = {{10, 5, 2, 6}, {1, 1, 8, 1, 1, 7, 1, 1, 6, 1, 1}, {1, 2, 3}}; // 8, 12
        int[] testCasesK = {100, 5, 0};
        for(int i = 0; i < testCasesNums.length; i++) {
            System.out.println(solution.numSubarrayProductLessThanK1(testCasesNums[i], testCasesK[i]));
        }
    }
    
    // Idea: Use two pointers i and j to track the continous subarray. i is the
    // first element, and j is the ending index.
    // Approach: update count when j increases
    // T(n) = O(n), where n is the length of nums.
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int product = 1;
        for(int i = 0, j = 0; j < nums.length; j++) {
            product *= nums[j];
            for(; product >= k && i <= j; i++) {
                product /= nums[i];
            }
            result += j + 1 - i;
        }
        
        return result;
    }
    
    // Idea: Use two pointers i and j to track the continous subarray. i is the
    // first element, and j is the ending index.
    // Approach: update count when i increases
    // T(n) = O(n), where n is the length of nums.
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int result = 0;
        int product = nums[0];
        for(int i = 0, j = 1; i < nums.length; i++) {
            for(j = Math.max(i + 1, j); j < nums.length && product < k; j++) {
                product *= nums[j];
            }
            if(j == nums.length && product < k)
                result += j - i;
            else {
                result += j - 1 - i;
                product /= nums[i];
            }
        }
        
        return result;
    }
}

//    Runtime: 7 ms, faster than 98.91% of Java online submissions for Subarray Product Less Than K.
//    Memory Usage: 48.4 MB, less than 98.81% of Java online submissions for Subarray Product Less Than K.
