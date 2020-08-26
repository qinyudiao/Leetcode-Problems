package minimum_cost_for_tickets_983;

//	In a country popular for train travel, you have planned some train travelling one year in advance. 
//	The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
//	
//	Train tickets are sold in 3 different ways:
//		a 1-day pass is sold for costs[0] dollars;
//		a 7-day pass is sold for costs[1] dollars;
//		a 30-day pass is sold for costs[2] dollars.
//		
//	The passes allow that many days of consecutive travel.  For example, 
//	if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
//	
//	Return the minimum number of dollars you need to travel every day in the given list of days.

//	Note:
//		1 <= days.length <= 365
//		1 <= days[i] <= 365
//		days is in strictly increasing order.
//		costs.length == 3
//		1 <= costs[i] <= 1000

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[] days1 = {1, 4, 6, 7, 8, 20};
		int[] costs1 = {2, 7, 15};
		System.out.println(solution.mincostTickets(days1, costs1)); // 11

		int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
		int[] costs2 = {2, 7, 15};
		System.out.println(solution.mincostTickets(days2, costs2)); // 17
	}

	// O(n), where n is the largest number day in days.
	public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1] + 1]; // stores the optimal cost for each day
        
        for(int i = 0; i < days[0]; i++) {
        	dp[i] = 0;
        }
        
        for(int i = days[0], j = 0; i <= days[days.length-1]; i++) {
	        if(i == days[j]) {
        		int one = costs[0] + dp[i-1];
            	int seven = costs[1] + dp[Math.max(0, i - 7)];
            	int thirty = costs[2] + dp[Math.max(0, i - 30)];
	        	dp[i] = Math.min(Math.min(one, seven), thirty);
//	        	System.out.println(dp[i]);
	        	j++;
	        } else {
	        	dp[i] = dp[i-1];
	        }
	    }
        
        return dp[dp.length-1];
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Cost For Tickets.
//	Memory Usage: 37.7 MB, less than 66.49% of Java online submissions for Minimum Cost For Tickets.
