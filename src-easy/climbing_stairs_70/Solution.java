package climbing_stairs_70;

//	You are climbing a stair case. It takes n steps to reach to the top.
//
//	Each time you can either climb 1 or 2 steps. 
//	In how many distinct ways can you climb to the top?
		
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.climbStairs(2));
		System.out.println(solution.climbStairs(3));
		System.out.println(solution.climbStairs(4));
		System.out.println(solution.climbStairs(12));
	}
	
	// iterative / bottom up
	// T(n) = O(n)
	public int climbStairs(int n) {
		if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
		
		int result = 0;
		int lastOne = 1;
		int lastTwo = 2;
		for(int i = 2; i < n; i++) {
			result = lastOne + lastTwo;
			lastOne = lastTwo;
			lastTwo = result;
		}
		
        return result;
    }
}
