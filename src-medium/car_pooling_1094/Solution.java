package car_pooling_1094;

import java.util.Map;
import java.util.TreeMap;

//	You are driving a vehicle that has capacity empty seats initially available for passengers. 
//	The vehicle only drives east (ie. it cannot turn around and drive west.)
//	
//	Given a list of trips, trips[i] = [num_passengers, start_location, end_location] 
//	contains information about the i-th trip: the number of passengers that must be picked up, 
//	and the locations to pick them up and drop them off. 
//	The locations are given as the number of kilometers due east from your vehicle's initial location.
//	
//	Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

//	Constraints:
//		1. trips.length <= 1000
//		2. trips[i].length == 3
//		3. 1 <= trips[i][0] <= 100
//		4. 0 <= trips[i][1] < trips[i][2] <= 1000
//		5. 1 <= capacity <= 100000

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][][] testCasesTrips = {{{2, 1, 5}, {3, 3, 7}}, {{2, 1, 5}, {3, 3, 7}}, {{2, 1, 5}, {3, 5, 7}}, {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}};
		int[] testCasesCapacity = {4, 5, 3, 11}; // false, true, true, true
		for(int i = 0; i < testCasesTrips.length; i++) {
			System.out.println(solution.carPooling(testCasesTrips[i], testCasesCapacity[i]));
		}
	}

	// T(n) = O(n), where n is the length of trips.
	public boolean carPooling(int[][] trips, int capacity) {
		Map<Integer, Integer> map = new TreeMap<>(); // <start_location, num_passengers_getting_in>
		
		// Store the number of passengers getting in the car for each location in a TreeMap (sorted by location).
		for(int[] trip : trips) { // trips[i] = [num_passengers, start_location, end_location] 
			// Add num_passengers for each start_location
			if(map.containsKey(trip[1]))
				map.put(trip[1], map.get(trip[1]) + trip[0]);
			else
				map.put(trip[1], trip[0]);
			// Substract num_passengers for each end_location
			if(map.containsKey(trip[2]))
				map.put(trip[2], map.get(trip[2]) - trip[0]);
			else
				map.put(trip[2], -trip[0]);
		}
		
		// Count the number of passengers in the car at each location, if larger than the capacity, return false.
		int numPassengers = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			numPassengers += entry.getValue();
			if(numPassengers > capacity)
				return false;
		}
		
		return true;
	}
}

//	Runtime: 5 ms, faster than 66.03% of Java online submissions for Car Pooling.
//	Memory Usage: 39 MB, less than 89.09% of Java online submissions for Car Pooling.
