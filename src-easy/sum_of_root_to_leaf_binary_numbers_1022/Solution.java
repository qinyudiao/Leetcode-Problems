package sum_of_root_to_leaf_binary_numbers_1022;

import utilities.TreeNode;

//	Given a binary tree, each node has value 0 or 1. 
//	Each root-to-leaf path represents a binary number starting with the most significant bit. 
//	For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, 
//	then this could represent 01101 in binary, which is 13.
//	
//	For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
//	
//	Return the sum of these numbers.

//	Note:
//		1. The number of nodes in the tree is between 1 and 1000.
//		2. node.val is 0 or 1.
//		3. The answer will not exceed 2^31 - 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		Integer[][] testCases = {{1, 0, 1, 0, 1, 0, 1}};
		for(Integer[] testCase : testCases) {
			TreeNode root = new TreeNode(testCase);
			System.out.println(root.toStringBFS());
			System.out.println(solution.sumRootToLeaf(root));
		}
	}

	// Idea: recursive dfs.
	// T(n): O(n), where n is the number of nodes.
	// S(n): O(n).
	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeafDFS(root, 0);
    }
	
	public int sumRootToLeafDFS(TreeNode root, int base) {
		int sum = 0;
		base = (base << 1) + root.val;
		if(root.left != null)
			sum += sumRootToLeafDFS(root.left, base); 
		if(root.right != null)
			sum += sumRootToLeafDFS(root.right, base);
		else if(root.left == null)
			sum += base;
		return sum;
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Root To Leaf Binary Numbers.
//	Memory Usage: 39.3 MB, less than 55.80% of Java online submissions for Sum of Root To Leaf Binary Numbers.

