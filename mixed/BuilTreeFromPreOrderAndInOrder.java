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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null)
            return null;
        if(preorder.length!=inorder.length)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd || inStart>inEnd)
            return null;
        int val=preorder[preStart];
        TreeNode root=new TreeNode(val);
        int offset=inStart;
        for(;offset<inEnd;offset++){
            if(inorder[offset]==val)
                break;
        }
        root.left=buildTree(preorder,preStart+1,preStart+offset-inStart,inorder,inStart,offset-1);
        root.right=buildTree(preorder,preStart+offset-inStart+1,preEnd,inorder,offset+1,inEnd);
        return root;
    }
}
