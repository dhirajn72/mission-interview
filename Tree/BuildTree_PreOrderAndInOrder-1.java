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
        if(preorder==null && inorder==null)
            return null;
        if(preorder==null || inorder==null)
            return null;
        if(preorder.length!=inorder.length)
            return null;
        return buildTree(preorder, 0, preorder.length-1,inorder,0,inorder.length-1);
    }
    TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart>preend  || instart>inend){
            return null;
        }

        int val=preorder[prestart];
        int i=instart;
        for(;i<inend;i++){
            if(val==inorder[i]){
                break;
            }
        }
        TreeNode root=new TreeNode(val);
        root.left=buildTree(preorder,prestart+1,prestart+i-instart,inorder,instart,i-1);
        root.right=buildTree(preorder,prestart+i-instart+1,preend,inorder,i+1,inend);
        return root;
    }
}
