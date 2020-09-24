package best_time_to_buy_and_sell_stock_121;

//	Say you have an array for which the ith element is the price of a given stock on day i.
//	
//	If you were only permitted to complete at most one transaction 
//	(i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//	
//	Note that you cannot sell a stock before you buy one.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}}; // 5, 0
		for(int[] testCase : testCases) {
			System.out.println(solution.maxProfit(testCase));	
		}
	}

	// Idea: iterative
	// O(n)
	public int maxProfit(int[] prices) {
		int max = 0;
		int localMin = Integer.MAX_VALUE;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i-1] < localMin)
				localMin = prices[i-1];
			if(prices[i] - localMin > max)
				max = prices[i] - localMin;
		}
        return max;
	}
}

//	Runtime: 1 ms, faster than 99.32% of Java online submissions for Best Time to Buy and Sell Stock.
//	Memory Usage: 39.1 MB, less than 95.11% of Java online submissions for Best Time to Buy and Sell Stock.
