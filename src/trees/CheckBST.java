package trees;
/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class CheckBST {
	public boolean solution(TreeNode root) {
		return checkBSTUtil(root, null, null);
	}
	
	public boolean checkBSTUtil(TreeNode root, Integer low, Integer high) {
		if(root == null) {
			return true;
		}
		
		if(low != null && root.val < low) {
			return false;
		}
		
		if(high != null && root.val > high) {
			return false;
		}
		return checkBSTUtil(root.left, low, root.val) && checkBSTUtil(root.right, root.val, high);
	}
	
	public static void main(String[] args) { 
    	TreeNode root = new TreeNode(5); 
    	root.left = new TreeNode(3); 
    	root.right = new TreeNode(8); 
    	root.left.left = new TreeNode(2); 
    	root.left.right = new TreeNode(4);  
        
    	CheckBST checkBST = new CheckBST();
    	
		System.out.println(checkBST.solution(root));
	}

}
