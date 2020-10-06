package complement_of_base_10_integer_1009;

//    Every non-negative integer N has a binary representation. 
//    For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on. 
//    Note that except for N = 0, there are no leading zeroes in any binary representation.
//    
//    The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1. 
//    For example, the complement of "101" in binary is "010" in binary.
//    
//    For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
        
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testCases = {5, 7, 10, 0}; // 2, 0, 5, 1
        for(int testCase : testCases) {
            System.out.println(solution.bitwiseComplement(testCase));
        }
    }
    
    // The complement number is the xor of N and the max value(Unsigned) with the same highestOneBit.
    // For example: 101 ^ 111 = 010.
    // Mask = 2 * Integer.highestOneBit(N) - 1.
    // Edge case: when N is 0, the mask should be 1.
    public int bitwiseComplement(int N) {
        return N != 0 ? N ^ (2 * Integer.highestOneBit(N) - 1) : 1;
    }
}

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Complement of Base 10 Integer.
//    Memory Usage: 35.7 MB, less than 97.83% of Java online submissions for Complement of Base 10 Integer.
