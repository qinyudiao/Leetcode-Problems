package k_diff_pairs_in_an_array_532;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//    Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//    
//    A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//        0 <= i, j < nums.length
//        i != j
//        a <= b
//        b - a == k

//    Constraints:
//        1 <= nums.length <= 104
//        -107 <= nums[i] <= 107
//        0 <= k <= 107

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCasesNums = {{3, 1, 4, 1, 5}, {1, 2, 3, 4, 5}, {1, 3, 1, 5, 4}, {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, {-1, -2, -3}, {1, 1, 1, 1, 1}}; // 2,
                                                                                                                                                    // 4,
                                                                                                                                                    // 1,
                                                                                                                                                    // 2,
                                                                                                                                                    // 2
        int[] testCasesK = {2, 1, 0, 3, 1, 0};
        for(int i = 0; i < testCasesNums.length; i++) {
            System.out.println(solution.findPairs(testCasesNums[i], testCasesK[i]));
        }
    }
    
    public int findPairs(int[] nums, int k) {
        if(nums.length < 2)
            return 0;
        
        Arrays.sort(nums);
        int numPairs = 0;
        
        if(k == 0) {
            boolean isAvailable = true;
            int lastNumber = nums[0];
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] == lastNumber) {
                    if(isAvailable) {
                        numPairs++;
                        isAvailable = false;
                    }
                }
                else {
                    lastNumber = nums[i];
                    isAvailable = true;
                }
            }
        }
        else {
            Set<Integer> numsSet = new HashSet<>();
            Set<Integer> targetsSet = new HashSet<>();
            for(int num : nums) {
                numsSet.add(num);
                targetsSet.add(num + k);
            }
            for(int num : numsSet) {
                if(targetsSet.contains(num))
                    numPairs++;
            }
        }
        
        return numPairs;
    }
}
