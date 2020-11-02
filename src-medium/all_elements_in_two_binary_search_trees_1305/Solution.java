package all_elements_in_two_binary_search_trees_1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import merge_two_sorted_arraylists.MergeTwoSortedArrayLists;
import utilities.TreeNode;

//	Given two binary search trees root1 and root2.
//	
//	Return a list containing all the integers from both trees sorted in ascending order.

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        TreeNode r1n1 = new TreeNode(1);
        TreeNode r1n4 = new TreeNode(4);
        TreeNode root1 = new TreeNode(2, r1n1, r1n4);
        TreeNode r2n0 = new TreeNode(0);
        TreeNode r2n3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2, r2n0, r2n3);
        System.out.println(solution.getAllElements(root1, root2)); // Input: root1 = [2,1,4], root2 = [1,0,3] => Output: [0,1,1,2,3,4]
        
        TreeNode r1nn10 = new TreeNode(-10);
        TreeNode r1n10 = new TreeNode(10);
        root1 = new TreeNode(0, r1nn10, r1n10);
        r2n0 = new TreeNode(0);
        TreeNode r2n2 = new TreeNode(2);
        TreeNode r2n1 = new TreeNode(1, r2n0, r2n2);
        TreeNode r2n7 = new TreeNode(7);
        root2 = new TreeNode(5, r2n1, r2n7);
        System.out.println(solution.getAllElements(root1, root2)); // Input: root1 = [0,-10,10], root2 = [5,1,7,0,2] => Output:
                                                                   // [-10,0,0,1,2,5,7,10]
        
        root1 = null;
        System.out.println(solution.getAllElements(root1, root2)); // Input: root1 = [], root2 = [5,1,7,0,2] => Output: [0,1,2,5,7]
    }
    
    // extract values into one list then sort it
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        if(root1 != null)
            TreeNode.extractValues(root1, result);
        if(root2 != null)
            TreeNode.extractValues(root2, result);
        Collections.sort(result); // Timsort has a O(n) runtime in this case because only one iteration of
                                  // insertion sort is needed
        return result;
    }
    
    // extract values as two sorted lists and merge the two lists
    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2.extractValues();
        else if(root2 == null)
            return root1.extractValues();
        return MergeTwoSortedArrayLists.mergeTwoSortedArrayLists(root1.extractValues(), root2.extractValues());
    }
}

//	Runtime: 13 ms, faster than 91.41% of Java online submissions for All Elements in Two Binary Search Trees.
//	Memory Usage: 42 MB, less than 91.82% of Java online submissions for All Elements in Two Binary Search Trees.
