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
        if(inorder==null || postorder==null)
            return null;
        if(postorder.length!=inorder.length)
            return null;
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    TreeNode buildTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd){
        if(postStart > postEnd || inStart > inEnd)
            return null;
        int val=postorder[postEnd];
        TreeNode root=new TreeNode(val);
        int offset=inStart;
        for(;offset<inEnd;offset++){
            if(inorder[offset]==val)
                break;
        }
        root.left=buildTree(postorder,postStart,postStart+offset-inStart-1,inorder,inStart,offset-1);
        root.right=buildTree(postorder,postStart+offset-inStart,postEnd,inorder,offset+1,inEnd);
        return root;
    }
}
