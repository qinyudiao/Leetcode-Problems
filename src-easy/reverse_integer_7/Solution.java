package reverse_integer_7;

import java.util.ArrayList;
import java.util.List;

//	Given a 32-bit signed integer, reverse digits of an integer.

//	Note:
//		Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
//		For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] testCases = {123, -123, 120, 0, 1534236469, -1534236469, -2147483412}; // 321, -321, 21, 0, 0, 0, -2143847412
        for(int testCase : testCases) {
            System.out.println(solution.reverse(testCase));
        }
    }
    
//	T(n): O(log(n)). There are roughly log10(n) digits in n.	
    public int reverse(int x) {
        long result = 0;
        
        while(x != 0) {
            int digit = (x % 10);
            x /= 10;
            result = result * 10 + digit;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        
        return (int) result;
    }
    
//	Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
//	Memory Usage: 36.6 MB, less than 88.49% of Java online submissions for Reverse Integer.
    
//	Same runtime, but Math.pow() takes more time.
    public int reverse1(int x) {
        List<Integer> digits = new ArrayList<>();
        
        while(x != 0) {
            digits.add(x % 10);
            x /= 10;
        }
        
        long result = 0;
        
        for(int i = digits.size() - 1; i >= 0; i--) {
            result += digits.get(i) * (Math.pow(10, digits.size() - i - 1));
            if(result == 0 || result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        
        return (int) result;
    }
}
