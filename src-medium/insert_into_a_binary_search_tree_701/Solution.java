package insert_into_a_binary_search_tree_701;

import utilities.TreeNode;

//    You are given the root node of a binary search tree (BST) and a value to insert into the tree. 
//    Return the root node of the BST after the insertion. 
//    It is guaranteed that the new value does not exist in the original BST.
//    
//    Notice that there may exist multiple valid ways for the insertion, 
//    as long as the tree remains a BST after insertion. 
//    You can return any of them.

//    Constraints:
//        The number of nodes in the tree will be in the range [0, 104].
//        -108 <= Node.val <= 108
//        All the values Node.val are unique.
//        -108 <= val <= 108
//        It's guaranteed that val does not exist in the original BST.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Integer[][] testCasesRoots = {{4, 2, 7, 1, 3}, {40, 20, 60, 10, 30, 50, 70}, {4, 2, 7, 1, 3, null, null, null, null, null, null},
                {5, null, 14, null, null, 10, 77, null, null, null, null, null, null, 95, null, null}};
        int[] testCasesVals = {5, 25, 5, 4};
        for(int i = 0; i < testCasesRoots.length; i++) {
            TreeNode root = new TreeNode(testCasesRoots[i]);
            System.out.println("Before: " + root.toStringBFS());
            System.out.println("After: " + solution.insertIntoBST(root, testCasesVals[i]).toStringBFS());
        }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        insert(root, val);
        
        return root;
    }
    
    public void insert(TreeNode root, int val) {
        if(val < root.val) {
            if(root.left == null)
                root.left = new TreeNode(val);
            else
                insert(root.left, val);
        }
        else {
            if(root.right == null)
                root.right = new TreeNode(val);
            else
                insert(root.right, val);
        }
    }
}

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
//    Memory Usage: 39.4 MB, less than 98.69% of Java online submissions for Insert into a Binary Search Tree.
