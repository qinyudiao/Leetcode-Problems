package gas_station_134;

//	There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//	
//	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
//	You begin the journey with an empty tank at one of the gas stations.
//	
//	Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

//	Note:
//		If there exists a solution, it is guaranteed to be unique.
//		Both input arrays are non-empty and have the same length.
//		Each element in the input arrays is a non-negative integer.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] testCasesGas = {{1, 2, 3, 4, 5}, {2, 3, 4}}; // 3, -1
		int[][] testCasesCost = {{3, 4, 5, 1, 2}, {3, 4, 3}};
		for(int i = 0; i < testCasesGas.length; i++) {
			System.out.println(solution.canCompleteCircuit(testCasesGas[i], testCasesCost[i]));
		}
	}

	// Idea: If a car starts from station i and fails to reach station j, then stations [i, j) can not be the starting station.
	// T(n) = O(n)
	// S(n) = O(1)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasInTank = 0;
		int startStation = 0;
		for(int i = 0; i < gas.length; i++) {
			gasInTank = gasInTank + gas[i] - cost[i];
			if(gasInTank < 0) {
				gasInTank = 0;
				startStation = i + 1;
			}
		}
		
		for(int i = 0; i < startStation; i++) {
			gasInTank = gasInTank + gas[i] - cost[i];
			if(gasInTank < 0)
				return -1;
		}
		
		return startStation;
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
//	Memory Usage: 39.7 MB, less than 70.51% of Java online submissions for Gas Station.
