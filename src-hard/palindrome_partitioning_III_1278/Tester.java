package palindrome_partitioning_III_1278;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tester {
    
    @Test
    public void t0() {
        Solution s = new Solution();
        assertTrue(s.palindromePartition("abc", 2) == 1);
    }
    
    @Test
    public void t1() {
        Solution s = new Solution();
        assertTrue(s.palindromePartition("aabbc", 3) == 0);
    }
    
    @Test
    public void t2() {
        Solution s = new Solution();
        assertTrue(s.palindromePartition("leetcode", 8) == 0);
    }
}
