package number_of_1_bits_191;

//	Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCases = {"00000000000000000000000000001011", "00000000000000000000000010000000", "11111111111111111111111111111101"}; // 3, 1, 31
		for(String testCase : testCases) {
			System.out.println(solution.hammingWeight(Integer.parseUnsignedInt(testCase, 2)));	
		}
	}
	
	public int hammingWeight(int n) {
		return Integer.bitCount(n);
	}
}
