package remove_duplicate_letters_316;

import java.util.Stack;

//    Given a string s, remove duplicate letters so that every letter appears once and only once. 
//    You must make sure your result is the smallest in lexicographical order among all possible results.

//    Constraints:
//        1 <= s.length <= 104
//        s consists of lowercase English letters.

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] testCases = {"bcabc", "cbacdcbc"}; // "abc", "acdb"
        for(String testCase : testCases) {
            System.out.println(solution.removeDuplicateLetters(testCase));
        }
    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int l = c - 'a';
            if(!inStack[l]) {
                while(!stack.isEmpty() && c < stack.peek() && i < lastIndex[stack.peek() - 'a']) {
                    inStack[stack.pop() - 'a'] = false;
                }
                stack.push(c);
                inStack[l] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

//    Runtime: 2 ms, faster than 92.21% of Java online submissions for Remove Duplicate Letters.
//    Memory Usage: 38.7 MB, less than 8.85% of Java online submissions for Remove Duplicate Letters.

