package teemo_attacking_495;

//	In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. 
//	Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, 
//	you need to output the total time that Ashe is in poisoned condition.
//	
//	You may assume that Teemo attacks at the very beginning of a specific time point, 
//	and makes Ashe be in poisoned condition immediately.

//	Note:
//		You may assume the length of given time series array won't exceed 10000.
//		You may assume the numbers in the Teemo's attacking time series
//		and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCasesTimeSeries = {{1, 4}, {1, 2}, {2}}; // 4, 3, 5
		int[] testCasesDuration = {2, 2, 5};
		for(int i = 0; i < testCasesTimeSeries.length; i++) {
			System.out.println(solution.findPoisonedDuration(testCasesTimeSeries[i], testCasesDuration[i]));	
		}
	}

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if(timeSeries == null || timeSeries.length == 0)
			return 0;
		
		int totalDuration = 0;
		for(int i = 0; i < timeSeries.length - 1; i++) {
			totalDuration += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
		}
		
		return totalDuration + duration;
	}
}

//	Runtime: 1 ms, faster than 100.00% of Java online submissions for Teemo Attacking.
//	Memory Usage: 40.6 MB, less than 99.01% of Java online submissions for Teemo Attacking.
