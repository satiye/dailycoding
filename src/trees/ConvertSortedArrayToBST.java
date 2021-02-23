package trees;
/*
 * 
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class ConvertSortedArrayToBST {
	public TreeNode solution(int nums[]) {
		return constructBSTUtil(nums, 0, nums.length-1);
	}
	
	private TreeNode constructBSTUtil(int nums[], int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = start +(end-start) /2;
		System.out.println(start + ":"+ end + ":"+mid);
		
		TreeNode node = new TreeNode(nums[mid]);
		
		node.left = constructBSTUtil(nums, start, mid-1);
		node.right = constructBSTUtil(nums, mid+1, end);
		
		return node;
	}
	
	public static void main(String[] args) { 
    	ConvertSortedArrayToBST convertSortedArrayToBST = new ConvertSortedArrayToBST();
    	TreeNode root = convertSortedArrayToBST.solution(new int[] {1,2,3,4,5});
    	
    	CheckBST checkBST = new CheckBST();
		System.out.println(checkBST.solution(root));
	}
}
