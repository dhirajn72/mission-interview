public class BuildTreePostAndInorder {
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
	class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if(inorder==null && postorder==null)
				return null;
			if(inorder==null || postorder==null)
				return null;
			if(inorder.length!=postorder.length)
				return null;
			return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
		}
		TreeNode buildTree(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend){
			if(poststart>postend || instart>inend)
				return null;
			int val=postorder[postend];
			int offset=instart;
			for(;offset<inend;offset++){
				if(inorder[offset]==val) break;
			}
			TreeNode root=new TreeNode(val);
			root.left=buildTree(postorder,poststart,poststart+offset-instart-1,inorder,instart,offset-1);
			root.right=buildTree(postorder,poststart+offset-postend-1,postend,inorder,offset+1,inend);
			return root;
		}
	}
}
