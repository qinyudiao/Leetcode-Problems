package number_of_longest_increasing_subsequence_673;

//    Given an integer array nums, return the number of longest increasing subsequences.
        
//    Constraints:
//        0 <= nums.length <= 2000
//        -10^6 <= nums[i] <= 10^6
    
public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{1,3,5,4,7}, {2,2,2,2,2}}; // 2, 5
        for(int[] testCase : testCases) {
            System.out.println(solution.findNumberOfLIS(testCase));
        }
    }
    
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int maxLength = 1;
        int currLength = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                currLength++;
                if(currLength == maxLength)
                    count++;
                else if(currLength > maxLength){
                    maxLength = currLength;
                    count = 1;
                }
            }
            else {
                currLength = 1;
                if(maxLength == 1)
                    count++;
            }
        }
        
        return count;
    }
}
