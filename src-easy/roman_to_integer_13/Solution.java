package roman_to_integer_13;

import java.util.HashMap;

//	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//	
//	Symbol       Value
//	I             1
//	V             5
//	X             10
//	L             50
//	C             100
//	D             500
//	M             1000
//	For example, two is written as II in Roman numeral, just two one's added together. 
//	Twelve is written as, XII, which is simply X + II. 
//	The number twenty seven is written as XXVII, which is XX + V + II.
//	
//	Roman numerals are usually written largest to smallest from left to right. 
//	However, the numeral for four is not IIII. Instead, the number four is written as IV. 
//	Because the one is before the five we subtract it making four. 
//	The same principle applies to the number nine, which is written as IX. 
//	There are six instances where subtraction is used:
//		I can be placed before V (5) and X (10) to make 4 and 9. 
//		X can be placed before L (50) and C (100) to make 40 and 90. 
//		C can be placed before D (500) and M (1000) to make 400 and 900.
//	Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testCases = {"III", "IV", "IX", "LVIII", "MCMXCIV"}; // 3, 4, 9, 58, 1994
        
        for(String testCase : testCases) {
            System.out.print(solution.romanToInt(testCase) + ", ");
        }
    }
    
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int integer_value = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 == s.length())
                integer_value += map.get(s.charAt(i));
            else if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                integer_value = integer_value - map.get(s.charAt(i)) + map.get(s.charAt(i + 1));
                i++;
            }
            else {
                integer_value += map.get(s.charAt(i));
            }
        }
        
        return integer_value;
    }
}

//	Runtime: 5 ms, faster than 75.45% of Java online submissions for Roman to Integer.
//	Memory Usage: 40.5 MB, less than 40.74% of Java online submissions for Roman to Integer.
