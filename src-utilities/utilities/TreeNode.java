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
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
    	this.val = val;
    	this.left = left;
    	this.right = right;
    }
    
    public String deepToString() {
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
 