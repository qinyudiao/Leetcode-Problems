package house_robber_III_337;

import utilities.TreeNode;

//	The thief has found himself a new place for his thievery again. 
//	There is only one entrance to this area, called the "root." 
//	Besides the root, each house has one and only one parent house. 
//	After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
//	It will automatically contact the police if two directly-linked houses were broken into on the same night.
//	
//	Determine the maximum amount of money the thief can rob tonight without alerting the police.

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[][] testCases = {{3, 2, 3, null, 3, null, 1}, // 7
                {3, 4, 5, 1, 3, null, 1}, // 9
                {2, 1, 3, null, 4}}; // 7
        for(Integer[] testCase : testCases) {
            System.out.println(solution.rob(new TreeNode(testCase)));
        }
    }
    
    // Idea: recursive
    // T(n) = O(n), where n is the number of nodes.
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        
        int[] result = robRecursive(root);
        
        return Math.max(result[0], result[1]);
    }
    
    public int[] robRecursive(TreeNode root) {
        int[] result = new int[2];
        int[] left = new int[2];
        int[] right = new int[2];
        if(root.left != null)
            left = robRecursive(root.left);
        if(root.right != null)
            right = robRecursive(root.right);
        
        result[0] = Math.max(root.val + left[1] + right[1], left[0] + right[0]);
        result[1] = left[0] + right[0];
        return result;
    }
}
