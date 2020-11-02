package partition_labels_763;

import java.util.ArrayList;
import java.util.List;

//	A string S of lowercase English letters is given. 
//	We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
//	and return a list of integers representing the size of these parts.

//	Note:
//		S will have length in range [1, 500].
//		S will consist of lowercase English letters ('a' to 'z') only.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] testCases = {"ababcbacadefegdehijhklij", "", "a", "abbcbcdefegdehijhklij"}; // [9, 7, 8], [], [1], [1, 5, 7, 8]
        for(String testCase : testCases) {
            System.out.println(solution.partitionLabels(testCase));
        }
        
    }
    
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        
        int[] lastIndices = new int[26];
        for(int i = S.length() - 1; i >= 0; i--) {
            if(lastIndices[S.charAt(i) - 'a'] == 0)
                lastIndices[S.charAt(i) - 'a'] = i;
        }
        
        for(int i = 0; i < S.length();) {
            int endOfPartition = lastIndices[S.charAt(i) - 'a'];
            for(int j = i + 1; j < endOfPartition; j++) { // refractor this loop into a method could reduce the runtime to 1 ms
                System.out.println("i: " + i + ", j: " + j + ", endOfPar: " + endOfPartition);
                if(lastIndices[S.charAt(j) - 'a'] > endOfPartition)
                    endOfPartition = lastIndices[S.charAt(j) - 'a'];
            }
            result.add(endOfPartition - i + 1);
            i = endOfPartition + 1;
            System.out.println("result: " + result);
        }
        
        return result;
    }
}

//	Runtime: 2 ms, faster than 99.65% of Java online submissions for Partition Labels.
//	Memory Usage: 37.9 MB, less than 92.99% of Java online submissions for Partition Labels.
