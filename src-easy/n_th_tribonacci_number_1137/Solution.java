package n_th_tribonacci_number_1137;

//	The Tribonacci sequence Tn is defined as follows: 
//
//	T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//	Given n, return the value of Tn.
		
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.tribonacci(2));
		System.out.println(solution.tribonacci(3));
		System.out.println(solution.tribonacci(4));
		System.out.println(solution.tribonacci(25));
	}
	
	// iterative / bottom up
	// T(n) = O(n)
	public int tribonacci(int n) {
		if(n == 0)
			return 0;
		else if(n <= 2) // n == 1 || n == 2
			return 1;
		
		int result = 0;
		int lastThree = 0;
		int lastTwo = 1;
		int lastOne = 1;
		for(int i = 2; i < n; i++) {
//			System.out.print(lastOne + " ");
			result = lastOne + lastTwo + lastThree;
			lastThree = lastTwo;
			lastTwo = lastOne;
			lastOne = result;
		}
//		System.out.print(" ------ ");
		return result;
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
//	Memory Usage: 36.1 MB, less than 79.12% of Java online submissions for N-th Tribonacci Number.
