package sum_of_left_leaves_404;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

//	Find the sum of all left leaves in a given binary tree.

//	  3
//	 / \
// 	9  20
//	  /  \
//	 15   7
//	
//	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        TreeNode n20 = new TreeNode(20, n15, n7);
        TreeNode n9 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n9, n20);
        System.out.println(solution.sumOfLeftLeaves(root));
    }
    
    // iterative
    public int sumOfLeftLeaves(TreeNode root) {
        int sumOfLeftLeaves = 0;
        
        Queue<TreeNode> toVisit = new LinkedList<>();
        TreeNode curr = root;
        if(curr != null)
            toVisit.add(curr);
        while(!toVisit.isEmpty()) {
            curr = toVisit.poll();
            if(curr.left != null) {
                if(curr.left.left == null && curr.left.right == null)
                    sumOfLeftLeaves += curr.left.val;
                if(curr.left.left != null || curr.left.right != null)
                    toVisit.add(curr.left);
            }
            if(curr.right != null && (curr.right.left != null || curr.right.right != null))
                toVisit.add(curr.right);
        }
        
        return sumOfLeftLeaves;
    }
}
