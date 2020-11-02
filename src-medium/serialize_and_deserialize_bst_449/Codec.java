package serialize_and_deserialize_bst_449;

import java.util.LinkedList;
import java.util.Queue;

import utilities.TreeNode;

//    Serialization is converting a data structure or object into a sequence of bits 
//    so that it can be stored in a file or memory buffer, 
//    or transmitted across a network connection link
//    to be reconstructed later in the same or another computer environment.
//    
//    Design an algorithm to serialize and deserialize a binary search tree. 
//    There is no restriction on how your serialization/deserialization algorithm should work. 
//    You need to ensure that a binary search tree can be serialized to a string, 
//    and this string can be deserialized to the original tree structure.
//    
//    The encoded string should be as compact as possible.

//    Constraints:
//        The number of nodes in the tree is in the range [0, 104].
//        0 <= Node.val <= 104
//        The input tree is guaranteed to be a binary search tree.

public class Codec {
    
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        
        TreeNode root = new TreeNode(new Integer[] {41, 6, 8469, 0, 22, 6336, 9177, null, 3, 15, 31, 5734, 6509, 8770, 9379, 2, 4, 10, 20, 28, 39,
                1490, 5775, 6410, 6986, 8493, 8823, 9298, 9975, 1, null, null, 5, 8, 12, 16, 21, 26, 29, 34, 40, 506, 4491, 5737, 6034, 6384, 6434,
                6853, 8178, 8492, 8503, 8779, 9106, 9283, 9339, 9774, 9982, null, null, null, null, 7, 9, 11, 13});
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(tree);
        System.out.println(ans.toStringBFS());
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        
        StringBuilder sb = new StringBuilder("");
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size() > 0) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("null ");
                continue;
            }
            sb.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }
        
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
            return null;
        
        String[] tokens = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        for(int i = 1; i < tokens.length; i++) {
            TreeNode curr = queue.poll();
            if(!tokens[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(curr.left);
            }
            i++;
            if(i < tokens.length && !tokens[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(curr.right);
            }
        }
        
        return root;
    }
}
