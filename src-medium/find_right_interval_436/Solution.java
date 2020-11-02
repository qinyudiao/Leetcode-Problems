package find_right_interval_436;

import java.util.Arrays;
import java.util.Comparator;

//	Given a set of intervals, for each of the interval i, 
//	check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, 
//	which can be called that j is on the "right" of i.
//	
//	For any interval i, you need to store the minimum interval j's index, 
//	which means that the interval j has the minimum start point to build the "right" relationship for interval i. 
//	If the interval j doesn't exist, store -1 for the interval i. 
//	Finally, you need output the stored value of each interval as an array.

//	Note:
//		You may assume the interval's end point is always bigger than its start point.
//		You may assume none of these intervals have the same start point.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] intervals1 = {{1, 2}};
        System.out.println(Arrays.toString(solution.findRightInterval(intervals1))); // [-1]
        
        int[][] intervals2 = {{3, 4}, {2, 3}, {1, 2}};
        System.out.println(Arrays.toString(solution.findRightInterval(intervals2))); // [-1, 0, 1]
        
        int[][] intervals3 = {{1, 4}, {2, 3}, {3, 4}};
        System.out.println(Arrays.toString(solution.findRightInterval(intervals3))); // [-1, 2, -1]
    }
    
    // O(n*logn)
    public int[] findRightInterval(int[][] intervals) {
//		if(intervals.length == 0)
//			return null;
//		else if(intervals.length == 1)
//			return new int[]{-1};
        
        int[][] startIndices = new int[intervals.length][2];
        
        // O(n)
        for(int i = 0; i < intervals.length; i++) {
            startIndices[i][0] = intervals[i][0]; // stores the start point value
            startIndices[i][1] = i; // stores the original index in intervals
        }
        
        // O(n*logn)
        Arrays.sort(startIndices, Comparator.comparingInt(arr -> arr[0]));
        System.out.println(Arrays.deepToString(startIndices));
        
        int[] result = new int[intervals.length];
        
        // O(n*logn), binary Search
        for(int i = 0; i < intervals.length; i++) {
            int start = 0, end = startIndices.length - 1;
            int ans = -1; // index of the minimum-"right" start point in intervals
            while(start <= end) {
                int mid = (start + end) / 2;
                if(startIndices[mid][0] < intervals[i][1])
                    start = mid + 1;
                else {
                    ans = startIndices[mid][1];
                    end = mid - 1;
                }
            }
            result[i] = ans;
        }
        
        return result;
    }
    
    // O(n + m) where n is the length of intervals, and m is the difference bewteen
    // minStartPoint and maxEndPoint.
    // this is a tradeoff, it could be faster if m is small, but could be slower or
    // exceed VM limit when difference is large.
    public int[] findRightInterval1(int[][] intervals) {
        int minStartPoint = Integer.MAX_VALUE;
        int maxEndPoint = Integer.MIN_VALUE;
        
        for(int i = 0; i < intervals.length; i++) {
            minStartPoint = Math.min(minStartPoint, intervals[i][0]);
            maxEndPoint = Math.max(maxEndPoint, intervals[i][1]);
        }
        
        int[] buckets = new int[maxEndPoint - minStartPoint + 1];
        
        for(int i = 0; i < intervals.length; i++) {
            buckets[intervals[i][0] - minStartPoint] = i + 1;
        }
        
        for(int i = buckets.length - 2; i > -1; i--) {
            if(buckets[i] == 0)
                buckets[i] = buckets[i + 1];
        }
        
        int[] result = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++) {
            result[i] = buckets[intervals[i][1] - minStartPoint];
        }
        
        return result;
    }
    
//	Runtime: 2 ms, faster than 99.85% of Java online submissions for Find Right Interval.
//	Memory Usage: 44.5 MB, less than 79.26% of Java online submissions for Find Right Interval.
    
}
