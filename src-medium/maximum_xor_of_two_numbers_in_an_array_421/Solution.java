package maximum_xor_of_two_numbers_in_an_array_421;

//	Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
//	
//	Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
//	
//	åCould you do this in O(n) runtime?
		
public class Solution {
	
	TrieNode root = new TrieNode();
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] testCases = {{3, 10, 5, 25, 2, 8}, {1, 2, 3}, {0, 0}}; // 28, 3, 0
		for(int[] testCase : testCases) {
			System.out.println(solution.findMaximumXOR(testCase));	
		}
	}
    
	// idea: Store nums in a Trie. Each insert() takes O(32). Then find the maxXOR for each number by going through the Trie. Each search takes O(32). Therefore, O(2 * (32 * n)).
	// O(n), where n is the length of nums.
	public int findMaximumXOR(int[] nums) {
		root = new TrieNode();
		for(int i = 0; i < nums.length; i++) {
			insert(nums[i]);
		}
		
		int maxXOR = 0;
		
		for(int num : nums){
			TrieNode curr = this.root;
			int max = 0;
			for(int i = 31; i >= 0; i--) { // go through the Trie to find the number that results in a maxXOR for current number
				int bit = (num >> i) & 1;
				if(bit == 1){
					if(curr.children[0] != null){
						max |= 1 << i;
						curr = curr.children[0];
					}
					else 
						curr = curr.children[1];
				}
				else {
					if(curr.children[1] != null){
						max |= 1 << i;
						curr = curr.children[1];
					}
					else 
						curr = curr.children[0];
				}
			}
			if(max > maxXOR)
				maxXOR = max;
		}
		
		return maxXOR;
	}
		
	public void insert(int num) {
		TrieNode curr = root;
		
		for(int i = 31; i >= 0; i--) {
			int bit = (num >> i) & 1;
			if (curr.children[bit] == null) {
				curr.children[bit] = new TrieNode(); 
			}
			curr = curr.children[bit];  
		}
	}
}

class TrieNode {
	TrieNode[] children;
	
	TrieNode() {
		children = new TrieNode[2];
	}
}

//	Runtime: 46 ms, faster than 54.99% of Java online submissions for Maximum XOR of Two Numbers in an Array.
//	Memory Usage: 54.9 MB, less than 36.08% of Java online submissions for Maximum XOR of Two Numbers in an Array.
