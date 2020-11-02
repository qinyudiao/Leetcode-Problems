package minimum_number_of_arrows_to_burst_balloons_452;

import java.util.Arrays;

//    There are some spherical balloons spread in two-dimensional space. 
//    For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
//    Since it's horizontal, y-coordinates don't matter, 
//    and hence the x-coordinates of start and end of the diameter suffice. 
//    The start is always smaller than the end.
//    
//    An arrow can be shot up exactly vertically from different points along the x-axis. 
//    A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. 
//    There is no limit to the number of arrows that can be shot. 
//    An arrow once shot keeps traveling up infinitely.
//    
//    Given an array points where points[i] = [xstart, xend], 
//    return the minimum number of arrows that must be shot to burst all balloons.

//    Constraints:
//        0 <= points.length <= 104
//        points.length == 2
//        -231 <= xstart < xend <= 231 - 1

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][][] testCases = {{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, {{1, 2}, {3, 4}, {5, 6}, {7, 8}}, {{1, 2}, {2, 3}, {3, 4}, {4, 5}}, {{1, 2}},
                {{2, 3}, {2, 3}}, {{1, 2}, {4, 5}, {1, 5}}, {{9, 12}, {1, 10}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}}; // 2, 4, 2, 1, 1, 2, 2
        for(int[][] testCase : testCases) {
            System.out.println(solution.findMinArrowShots(testCase));
        }
    }
    
    // Idea: Sort the points by the end points first. Then count 1 after finding
    // all the points start before the current point's end.
    // T(n) = O(nlogn).
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        
        Arrays.sort(points, (point1, point2) -> {
            return point1[1] > point2[1] ? 1 : -1;
        });
        
//        System.out.println(Arrays.deepToString(points));
        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }
        
        return count;
    }
}

//    Runtime: 14 ms, faster than 99.81% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
//    Memory Usage: 46.6 MB, less than 17.39% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
