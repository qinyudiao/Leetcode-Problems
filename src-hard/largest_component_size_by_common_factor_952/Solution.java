package largest_component_size_by_common_factor_952;

import java.util.HashMap;
import java.util.Map;

//	Given a non-empty array of unique positive integers A, consider the following graph:
//		There are A.length nodes, labelled A[0] to A[A.length - 1];
//		There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
//	Return the size of the largest connected component in the graph.

//	Note:
//		1. 1 <= A.length <= 20000
//		2. 1 <= A[i] <= 100000

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{4, 6, 15, 35}, {20, 50, 9, 63}, {2, 3, 6, 7, 4, 12, 21, 39}}; // 4, 2, 8
		for(int[] testCase : testCases) {
			System.out.println(solution.largestComponentSize(testCase));	
		}
	}
	
	// union-find solution
	public int largestComponentSize(int[] A) {
		Map<Integer,Integer> parent = new HashMap<>();

		// find each number's factors
		for(int num : A) {
			for(int factor = 2; factor*factor <= num; factor++) {
				if(num % factor == 0) {
					union(parent, num, factor);
					union(parent, num, num/factor);
				}
			}
        	}

		int max = 1;
		Map<Integer,Integer> freq = new HashMap<>();
		for (Integer v : A) {
			int f = find(parent, v);
			if (freq.containsKey(f)) {
				freq.put(f, freq.get(f) + 1);
				max = Math.max(max,freq.get(f));
			}
			else
				freq.put(f,1);
		}

		return max;
	}
    
	public void union(Map<Integer,Integer> parent, int x, int y) {
		int findX = find(parent, x), findY = find(parent, y);
		if(findX < findY)
			parent.put(findY, findX);
		else
			parent.put(findX, findY);
	}

	public int find(Map<Integer,Integer> parent, Integer i) {
		if(parent.get(i) == null)
			parent.put(i, i);

		while(i != parent.get(i)) {
			i = parent.get(i);
		}

		return i;
	}
}

//	Runtime: 183 ms, faster than 64.65% of Java online submissions for Largest Component Size by Common Factor.
//	Memory Usage: 46.9 MB, less than 70.70% of Java online submissions for Largest Component Size by Common Factor.
