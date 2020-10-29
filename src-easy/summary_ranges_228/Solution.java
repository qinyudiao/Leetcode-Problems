package summary_ranges_228;

import java.util.ArrayList;
import java.util.List;

//    You are given a sorted unique integer array nums.
//    
//    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. 
//    That is, each element of nums is covered by exactly one of the ranges, 
//    and there is no integer x such that x is in one of the ranges but not in nums.
//    
//    Each range [a,b] in the list should be output as:
//        "a->b" if a != b
//        "a" if a == b

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{0, 1, 2, 4, 5, 7}, {0, 2, 3, 4, 6, 8, 9}, {}, {-1}, {0}}; // ["0->2","4->5","7"], ["0","2->4","6","8->9"], [], ["-1"],
                                                                                        // ["0"]
        for(int[] testCase : testCases) {
            System.out.println(solution.summaryRanges(testCase));
        }
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        if(nums.length == 0)
            return result;
        
        int start = nums[0], end = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1] + 1) {
                StringBuilder range = new StringBuilder().append("\"").append(start);
                if(start != end)
                    range.append("->").append(end);
                range.append("\"");
                result.add(range.toString());
                start = nums[i];
            }
            end = nums[i];
        }
        
        StringBuilder range = new StringBuilder().append("\"").append(start);
        if(start != end)
            range.append("->").append(end);
        range.append("\"");
        result.add(range.toString());
        
        return result;
    }
}
