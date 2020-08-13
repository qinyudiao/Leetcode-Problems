package fibonacci_number_509;

import java.util.Arrays;

//	The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
//	such that each number is the sum of the two preceding ones, starting from 0 and 1. 
//	That is,
//		F(0) = 0,   F(1) = 1
//		F(N) = F(N - 1) + F(N - 2), for N > 1.
//	Given N, calculate F(N)

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.fib(2));
		System.out.println(solution.fib(3));
		System.out.println(solution.fib(4));
		System.out.println(solution.fib(12));
	}
	
	// iterative / bottom up
	// T(n) = O(n)
	public int fib2(int N) {
		if(N == 0)
            return 0;
        else if(N == 1)
            return 1;
		
		int result = 0;
		int lastOne = 0;
		int lastTwo = 1;
		for(int i = 1; i < N; i++) {
			result = lastOne + lastTwo;
			lastOne = lastTwo;
			lastTwo = result;
		}
		
        return result;
    }

	// recusive
	// T(n) = O(2^n)
	public int fib1(int N) {
		if(N == 0)
            return 0;
        else if(N == 1)
            return 1;
		
        return fib(N - 1) + fib(N - 2);
    }
	
	// memoize
	// T(n) = O(n)
	public int fib(int N) {
		if(N == 0)
            return 0;
		int[] memo = new int[N+1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
        return fib_memo(memo, N);
    }
	
	public int fib_memo(int[] memo, int N) {
		if(memo[N] != -1)
        	return memo[N];
        else
        	return memo[N] = fib_memo(memo, N - 1) + fib_memo(memo, N - 2);
    }
	
}
