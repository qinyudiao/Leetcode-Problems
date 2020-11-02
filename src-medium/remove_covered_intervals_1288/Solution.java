package remove_covered_intervals_1288;

import java.util.Arrays;

//    Given a list of intervals, remove all intervals that are covered by another interval in the list.
//    
//    Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
//    
//    After doing so, return the number of remaining intervals.

//    Constraints:
//        1 <= intervals.length <= 1000
//        intervals[i].length == 2
//        0 <= intervals[i][0] < intervals[i][1] <= 10^5

//        All the intervals are unique.
public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][][] testCases = {{{1, 4}, {3, 6}, {2, 8}}, {{1, 4}, {2, 3}}, {{0, 10}, {5, 12}}, {{3, 10}, {4, 10}, {5, 11}}, {{1, 2}, {1, 4}, {3, 4}}}; // 2,
                                                                                                                                                       // 1,
                                                                                                                                                       // 2,
                                                                                                                                                       // 2,
                                                                                                                                                       // 1
        for(int[][] testCase : testCases) {
            System.out.println(solution.removeCoveredIntervals(testCase));
        }
    }
    
    // Idea: Sort intervals based on start time. If the two intervals have the same
    // start time, the longer goes first. Then do a greedy approach to find all the
    // intervals to remove.
    // T(n) = O(n*logn).
    // S(n) = O(1).
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length < 2)
            return 0;
        
        Arrays.sort(intervals, (interval1, interval2) -> {
            if(interval1[0] < interval2[0])
                return -1;
            else if(interval1[0] > interval2[0])
                return 1;
            else {
                if(interval1[1] > interval2[1])
                    return -1;
                else if(interval1[1] < interval2[1])
                    return 1;
                else
                    return 0;
            }
        });
        
        int result = intervals.length;
        int lastEndIndex = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] <= lastEndIndex)
                result--;
            else
                lastEndIndex = intervals[i][1];
        }
        
        return result;
    }
}

//    Runtime: 4 ms, faster than 97.49% of Java online submissions for Remove Covered Intervals.
//    Memory Usage: 39.7 MB, less than 54.77% of Java online submissions for Remove Covered Intervals.
