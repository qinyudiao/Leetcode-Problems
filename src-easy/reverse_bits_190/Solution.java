package reverse_bits_190;

//	Reverse bits of a given 32 bits unsigned integer.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] testCases = {"00000010100101000001111010011100", "11111111111111111111111111111101"}; // "00111001011110000010100101000000"/964176192,
                                                                                                       // "10111111111111111111111111111111"/-1073741825(3221225471
                                                                                                       // in languages support unsigned int)
        for(String testCase : testCases) {
            System.out.println(solution.reverseBits(Integer.parseUnsignedInt(testCase, 2)));
        }
    }
    
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
