package combination_sum_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    Given an array of distinct integers candidates and a target integer target, 
//    return a list of all unique combinations of candidates where the chosen numbers sum to target. 
//    You may return the combinations in any order.
//    
//    The same number may be chosen from candidates an unlimited number of times. 
//    Two combinations are unique if the frequency of at least one of the chosen numbers is different.

//    Constraints:
//        1 <= candidates.length <= 30
//        1 <= candidates[i] <= 200
//        All elements of candidates are distinct.
//        1 <= target <= 500

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCasesCandidates = {{2, 3, 6, 7}, {2, 3, 5}, {2}, {1}, {1}}; // [[2, 2, 3], [7]],
                                                                                // [[2, 2, 2, 2], [2,3,3], [3, 5]],
                                                                                // [], [[1]], [[1, 1]]
        int[] testCasesTargets = {7, 8, 1, 1, 2};
        for(int i = 0; i < testCasesCandidates.length; i++) {
            System.out.println(solution.combinationSum(testCasesCandidates[i], testCasesTargets[i]));
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> validCombinations = new ArrayList<>();
        
        int i = candidates.length - 1;
        while(i >= 0 && candidates[i] > target) {
            i--;
        }
        for(; i >= 0; i--) {
            findValidCombinations(candidates, i, target, new ArrayList<>(), validCombinations);
        }
        
        return validCombinations;
    }
    
    public void findValidCombinations(int[] candidates, int i, int target, List<Integer> prevCombination, List<List<Integer>> validCombinations) {
        List<Integer> combination = new ArrayList<>();
        combination.addAll(prevCombination);
//        System.out.println("i: " + i + ", sum: " + sum + ", combination: " + combination + ", validCombinations: " + validCombinations);
        if(candidates[i] < target) {
            combination.add(candidates[i]);
            target -= candidates[i];
            for(; i >= 0; i--) {
                findValidCombinations(candidates, i, target, combination, validCombinations);
            }
        }
        else if(candidates[i] == target) {
            combination.add(candidates[i]);
            validCombinations.add(combination);
        }
    }
}
