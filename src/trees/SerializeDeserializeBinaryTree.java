package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 */

public class SerializeDeserializeBinaryTree {
	    public static final String DELIMETER = "@";
	    public static final String NULLSTR = "X";
	    
	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if(root == null){
	            return NULLSTR + DELIMETER;
	        }
	        
	        String leftString = serialize(root.left);
	        String rightString = serialize(root.right);
	        
	        return root.val + DELIMETER + leftString + rightString;
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        Queue<String> nodeList = new LinkedList<>();
	        nodeList.addAll(Arrays.asList(data.split(DELIMETER)));
	        
	        return deserializeHelper(nodeList);
	    }
	    
	    private TreeNode deserializeHelper(Queue<String> nodeList){  
	        String current = nodeList.poll();
	        
	        if(current.equals(NULLSTR)){
	            return null;
	        }
	    
	        TreeNode root = new TreeNode(Integer.valueOf(current));
	        root.left = deserializeHelper(nodeList);
	        root.right = deserializeHelper(nodeList);
	        
	        return root;
	    }
	    
	    public static boolean identicalTrees(TreeNode a, TreeNode b) { 
	        /*1. both empty */
	        if (a == null && b == null) 
	            return true; 
	              
	        /* 2. both non-empty -> compare them */
	        if (a != null && b != null)  
	            return (a.val == b.val 
	                    && identicalTrees(a.left, b.left) 
	                    && identicalTrees(a.right, b.right)); 
	   
	        /* 3. one empty, one not -> false */
	        return false; 
	    } 
	   
	    public static void main(String[] args) { 
	    	TreeNode before = new TreeNode(1); 
	    	before.left = new TreeNode(2); 
	    	before.right = new TreeNode(3); 
	    	before.left.left = new TreeNode(4); 
	    	before.left.right = new TreeNode(5);  
	        
	    	SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
	    	
	    	TreeNode after = serializeDeserializeBinaryTree.deserialize(serializeDeserializeBinaryTree.serialize(before));

			System.out.println(identicalTrees(before, after));
		}
}
