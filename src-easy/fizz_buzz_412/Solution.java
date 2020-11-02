package fizz_buzz_412;

import java.util.ArrayList;
import java.util.List;

//	Write a program that outputs the string representation of numbers from 1 to n.
//	
//	But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
//	For numbers which are multiples of both three and five output “FizzBuzz”.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println(solution.fizzBuzz(15));
    }
    
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                if(i % 5 == 0)
                    result.add("FizzBuzz");
                else
                    result.add("Fizz");
            }
            else if(i % 5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add(Integer.toString(i));
            }
        }
        
        return result;
    }
}

//	Runtime: 1 ms, faster than 99.51% of Java online submissions for Fizz Buzz.
//	Memory Usage: 40.7 MB, less than 72.01% of Java online submissions for Fizz Buzz.
