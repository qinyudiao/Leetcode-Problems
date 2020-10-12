package buddy_strings_859;

//    Given two strings A and B of lowercase letters, 
//    return true if you can swap two letters in A so the result is equal to B, 
//    otherwise, return false.
//    
//    Swapping letters is defined as taking two indices i and j (0-indexed) 
//    such that i != j and swapping the characters at A[i] and A[j]. 
//    For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

//    Constraints:
//        0 <= A.length <= 20000
//        0 <= B.length <= 20000
//        A and B consist of lowercase letters.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] testCasesA = {"ab", "ab", "aa", "aaaaaaabc", "", "abac"}; // true, false, true, true, false, false
        String[] testCasesB = {"ba", "ab", "aa", "aaaaaaacb", "aa", "abad"};
        for(int i = 0; i < testCasesA.length; i++) {
            System.out.println(solution.buddyStrings(testCasesA[i], testCasesB[i]));
        }
    }

    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() < 2 || B.length() < 2)
            return false;
        
        if(A.equals(B)) {
            boolean[] isInB = new boolean[26];
            for(int i = 0; i < A.length(); i++) {
                int c = B.charAt(i) - 'a';
                if(isInB[c]) 
                    return true;
                else
                    isInB[c] = true;
            }
            return false;
        }
        else {
            char a1 = '0', b1 = '0', a2 = '0', b2 = '0';
            for(int i = 0; i < A.length(); i++) {
                if(A.charAt(i) != B.charAt(i)) {
                    if(a1 == '0') {
                        a1 = A.charAt(i);
                        b1 = B.charAt(i);
                    }
                    else if(a2 == '0') {
                        a2 = A.charAt(i);
                        b2 = B.charAt(i);
                        if(a1 != b2 || a2 != b1)
                            return false;
                    }
                    else 
                        return false;
                }
            }
            return a2 != '0';
        }
    }
}

//    Runtime: 1 ms, faster than 99.31% of Java online submissions for Buddy Strings.
//    Memory Usage: 38.9 MB, less than 7.76% of Java online submissions for Buddy Strings.

