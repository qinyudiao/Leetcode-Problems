package first_missing_positive_41;

//    Given an unsorted integer array, find the smallest missing positive integer.

//    Follow up:
//        Your algorithm should run in O(n) time and uses constant extra space.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{1, 2, 0}, {3, 4, -1, 1}, {7, 8, 9, 11, 12}, {1, 2, 3}, {1, 1}, {1}}; // 3,
                                                                                                   // 2,
                                                                                                   // 1,
                                                                                                   // 4,
                                                                                                   // 2, 2
        for(int[] testCase : testCases) {
            System.out.println(solution.firstMissingPositive(testCase));
        }
    }
    
    // Idea: Iterate through nums and swap each element to the position i that
    // equals to the element value if i is within the range and the the elements to
    // swap is not equal. Then iterate through nums again to find the first element
    // that its value is not equal to its index. There's a special case that the
    // number length could be at nums[0].
    // T(n) = O(n), where n is the length of nums.
    // S(n) = O(1).
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        
        for(int i = 0; i < nums.length;) {
            if(nums[i] > 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else
                i++;
        }
        
        int positive = 1;
        while(positive < nums.length && positive == nums[positive]) {
            positive++;
        }
        
        return positive != nums[0] ? positive : positive + 1;
    }
}
