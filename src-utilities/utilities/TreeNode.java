package utilities;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	
    public TreeNode() {}
    
    public TreeNode(int val) { 
    	this.val = val;
    }
    
    public TreeNode(int[] values) {
    	this.val = values[0];
    	this.left = insertLevelOrder(values, this.left, 1);
    	this.right = insertLevelOrder(values, this.right, 2);
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
    	this.val = val;
    	this.left = left;
    	this.right = right;
    }
    
    public TreeNode insertLevelOrder(int[] values, TreeNode root, int i) {
		if (i < values.length) { 
			TreeNode temp = new TreeNode(values[i]); 
			root = temp; 
			root.left = insertLevelOrder(values, root.left, 2 * i + 1);
			root.right = insertLevelOrder(values, root.right, 2 * i + 2);
		} 
		return root; 
	}
    
    public List<Integer> extractValues() {
    	List<Integer> result = new ArrayList<>();
        if(this.left != null)
        	extractValues(this.left, result);

        result.add(this.val);
        
        if(this.right != null)
        	extractValues(this.right, result);

        return result;
    }
    
    public static void extractValues(TreeNode root, List<Integer> list) {
        if(root.left != null)
            extractValues(root.left, list);

        list.add(root.val);
        
        if(root.right != null)
            extractValues(root.right, list);
    }
    
    public String toStringInOrder() {
    	StringBuilder sb = new StringBuilder();
    	if(this != null) {
    		if(this.left != null)
    			sb.append(this.left.toStringInOrder()); 
            sb.append(this.val);
            sb.append(", "); 
            if(this.right != null)
            	sb.append(this.right.toStringInOrder()); 
        }
    	return sb.toString();
    }
    
    public String toStringDFS() { // DFS
    	StringBuilder sb = new StringBuilder();
    	if(this != null) {
    		sb.append(this.val);
            sb.append(", "); 
    		if(this.left != null)
    			sb.append(this.left.toStringInOrder()); 
            if(this.right != null)
            	sb.append(this.right.toStringInOrder()); 
        }
    	return sb.toString();
    }
    
    public String toStringBFS() { // BFS
    	List<Integer> vals = new ArrayList<>();
    	
    	List<TreeNode> toVisit = new ArrayList<>();
    	List<TreeNode> toVisitNext = new ArrayList<>();
    	toVisit.add(this);
    	while(!toVisit.isEmpty()) {
    		boolean allNull = true;
    		for(TreeNode node : toVisit) {
    			if(node == null) {
    				vals.add(null);
    				toVisitNext.add(null);
    				toVisitNext.add(null);
    			}
    			else {
    				vals.add(node.val);
    				if(node.left != null) {
    					toVisitNext.add(node.left);
    					allNull = false;
    				}
    				else 
    					toVisitNext.add(null);
    				
    				if(node.right != null) {
    					toVisitNext.add(node.right);
    					allNull = false;
    				}
    				else 
    					toVisitNext.add(null);
    			}
    		}
    		toVisit.clear();
    		if(!allNull) {
    			toVisit.addAll(toVisitNext);
    			toVisitNext.clear();
    		}
    	}
    	
		return vals.toString();
    }
}
 