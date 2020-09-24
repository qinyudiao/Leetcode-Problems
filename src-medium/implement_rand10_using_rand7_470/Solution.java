package implement_rand10_using_rand7_470;

//	Given the API rand7 which generates a uniform random integer in the range 1 to 7, 
//	write a function rand10 which generates a uniform random integer in the range 1 to 10. 
//	You can only call the API rand7 and you shouldn't call any other API. 
//	Please don't use the system's Math.random().
//	
//	Notice that Each test case has one argument n, 
//	the number of times that your implemented function rand10 will be called while testing. 
//	
//	Follow up:
//		What is the expected value for the number of calls to rand7() function?
//		Could you minimize the number of calls to rand7()?

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

public class Solution extends SolBase{

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] randomInts = new int[10];
		
		for(int i = 0; i < 10000; i++) {
			randomInts[solution.rand10() - 1] += 1;
		}
		
		for(int i = 0; i < randomInts.length; i++) {
			System.out.print((i + 1) + " : " + randomInts[i] + ", ");
		}
	}
	
	public int rand10() {
		int num = ((rand7() - 1) * 7) + rand7() - 1;
		return num >= 40 ? rand10() : num / 4 + 1;
	}
	
//	Runtime: 5 ms, faster than 99.11% of Java online submissions for Implement Rand10() Using Rand7().
//	Memory Usage: 44.4 MB, less than 98.82% of Java online submissions for Implement Rand10() Using Rand7().

	// n1 : 1 2 3 4 5 6 7, n2 : 1 2 3 4 5 6 7
	public int rand10A() {
		int n1 = rand7(), n2 = rand7();
		int n3 = n1 * 10 + n2;

		if(n3 >= 66)
			return rand10A();
		else if(n3 >= 62 && n3 < 66)
			return 10;
		else if(n3 >= 55 && n3 < 62)
			return 9;
		else if(n3 >= 51 && n3 < 55)
			return 8;
		else if(n3 >= 44 && n3 < 51)
			return 7;
		else if(n3 >= 37 && n3 < 44)
			return 6;
		else if(n3 >= 33 && n3 < 37)
			return 5;
		else if(n3 >= 26 && n3 < 33)
			return 4;
		else if(n3 >= 22 && n3 < 26)
			return 3;
		else if(n3 >= 15 && n3 < 22)
			return 2;
		else if(n3 >= 11 && n3 < 15)
			return 1;

			return -1;
	}
}

//	Runtime: 6 ms, faster than 60.65% of Java online submissions for Implement Rand10() Using Rand7().
//	Memory Usage: 45.1 MB, less than 81.51% of Java online submissions for Implement Rand10() Using Rand7().

