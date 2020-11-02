package best_time_to_buy_and_sell_stock_II_122;

//	Say you have an array prices for which the ith element is the price of a given stock on day i.
//	
//	Design an algorithm to find the maximum profit. 
//	You may complete as many transactions as you like 
//	(i.e., buy one and sell one share of the stock multiple times).
//	
//	Note: You may not engage in multiple transactions at the same time 
//	(i.e., you must sell the stock before you buy again).

//	Constraints:
//		1 <= prices.length <= 3 * 10 ^ 4
//		0 <= prices[i] <= 10 ^ 4

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] testCases = {{7, 1, 5, 3, 6, 4}, {1, 2, 3, 4, 5}, {7, 6, 4, 3, 1}, {3, 2, 6, 5, 0, 3}}; // 7, 4, 0, 7
        for(int[] testCase : testCases) {
            System.out.println(solution.maxProfit(testCase));
        }
    }
    
    // Idea: iterative
    // O(n)
    public int maxProfit(int[] prices) {
        int cumProfit = 0;
        int localMin = Integer.MAX_VALUE;
        int localMax = 0;
        for(int i = 1; i < prices.length; i++) {
            
            if(prices[i - 1] < localMin)
                localMin = prices[i - 1];
            if(prices[i] > localMax && prices[i] > localMin)
                localMax = prices[i];
            else if(localMax > localMin) {
                cumProfit += localMax - localMin;
                localMin = prices[i];
                localMax = 0;
            }
//			System.out.println("cum: " + cumProfit + ", localMax: " + localMax + ", localMin: " + localMin);
        }
        if(localMax > localMin)
            cumProfit += localMax - localMin;
        
        return cumProfit;
    }
}

//	Runtime: 1 ms, faster than 94.30% of Java online submissions for Best Time to Buy and Sell Stock II.
//	Memory Usage: 39.3 MB, less than 80.80% of Java online submissions for Best Time to Buy and Sell Stock II.
