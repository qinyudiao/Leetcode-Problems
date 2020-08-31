package delete_node_in_a_bst_450;

import utilities.TreeNode;

//	Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//	
//	Basically, the deletion can be divided into two stages:
//		1. Search for a node to remove.
//		2. If the node is found, delete the node.
//		
//	Note: Time complexity should be O(height of tree).

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
//		root = [5,3,6,2,4,null,7]
//				key = 3
//
//				    5
//				   / \
//				  3   6
//				 / \   \
//				2   4   7
				
//		One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
//
//		    5
//		   / \
//		  4   6
//		 /     \
//		2       7
//
//		Another valid answer is [5,2,6,null,4,null,7].
//	
//		    5
//		   / \
//		  2   6
//		   \   \
//		    4   7
		
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node3 = new TreeNode(3, node2, node4);
		TreeNode node6 = new TreeNode(6, null, node7);
		TreeNode node5 = new TreeNode(5, node3, node6);
		
		System.out.println("TreeNode Before: " + node5.deepToString());
		System.out.println("TreeNode After: " + solution.deleteNode(node5, 3).deepToString());
		System.out.println();
		System.out.println("TreeNode Before: " + node5.deepToString());
		System.out.println("TreeNode After: " + solution.deleteNode(node5, 0).deepToString());
		
		// [3, 1, 4, null, 2, null, null], 3 => [4, 1, null, null, 2, null, null]
		node2 = new TreeNode(2);
		node4 = new TreeNode(4);
		TreeNode node1 = new TreeNode(1, null, node2);
		node3 = new TreeNode(3, node1, node4);
		System.out.println();
		System.out.println("TreeNode Before: " + node3.deepToString());
		System.out.println("TreeNode After: " + solution.deleteNode(node3, 3).deepToString());
		
		// [1, null, 2], 1 => [2]
		node2 = new TreeNode(2);
		node1 = new TreeNode(1, null, node2);
		System.out.println();
		System.out.println("TreeNode Before: " + node1.deepToString());
		System.out.println("TreeNode After: " + solution.deleteNode(node1, 1).deepToString());
	}
	
	// trade-off: cleaner code, larger memory usage
	public TreeNode deleteNodeRevise(TreeNode root, int key) {
        if(root == null) // if root is null, return null
        	return root; 
  
        if(key < root.val) 
            root.left = deleteNodeRevise(root.left, key); 
        else if(key > root.val) 
            root.right = deleteNodeRevise(root.right, key); 
        else { // find the key
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            TreeNode curr = root.right;
            int min = curr.val; 
            while(curr.left != null) { 
                min = curr.left.val; 
                curr = curr.left; 
            } 
            root.val = min; 
            root.right = deleteNodeRevise(root.right, root.val); 
        } 
  
        return root;
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) // if root is null, return null
        	return null;
        if(root.left == null && root.right == null) // if root has no children, return null is root is the key to delete, otherwise return root
        	return root.val == key ? null : root;
		
        TreeNode parent = new TreeNode(Integer.MIN_VALUE, root, null);
        TreeNode rootParent = new TreeNode(Integer.MIN_VALUE, root, null);
        TreeNode curr = root;
		while(curr.val != key) { // find the key, if not found return the original BST
			parent = curr;
			if(key < curr.val) {
				if(curr.left != null)
					curr = curr.left;
				else
					return root;
			}
			else {
				if(curr.right != null)
					curr = curr.right;
				else
					return root;
			}
		}
		
		System.out.println("parent: " + parent.deepToString());
		System.out.println("curr: " + curr.deepToString());
		
		removeNode(parent, curr, root.val == key, rootParent);
		
        return rootParent.left;
    }
	
	public void removeNode(TreeNode parent, TreeNode curr, boolean changeRoot, TreeNode rootParent) {
		if(curr.left == null && curr.right == null) { // remove the leaf
			if(parent.left != null && parent.left.val == curr.val)
    			parent.left = null;
    		else
    			parent.right = null;
    		return;
		}
		else if(curr.left != null && curr.right == null) { // remove the node only has left child, point its parent to its left child
			if(parent.left != null && parent.left.val == curr.val) {
    			parent.left = curr.left;
    			if(changeRoot)
    				rootParent.left = curr.left;
			}
    		else
    			parent.right =  curr.left;
    		return;
		}
		else if(curr.left == null && curr.right != null) { // remove the node only has right child, point its parent to its right child
			if(parent.left != null && parent.left.val == curr.val) {
    			parent.left = curr.right;
				if(changeRoot)
					rootParent.left = curr.right;
			}
    		else
    			parent.right =  curr.right;
    		return;
		}
        
		// when the node to remove has two children, replace it with the next largest node in the tree
		TreeNode toReplace = curr;
		parent = curr;
		curr = curr.right;
        while(curr.left != null) {
        	parent = curr;
        	curr = curr.left;
        }
        toReplace.val = curr.val;
        removeNode(parent, curr, false, null);
	}
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
//	Memory Usage: 40 MB, less than 58.30% of Java online submissions for Delete Node in a BST.
