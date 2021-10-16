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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        return deleteNodeFromTree(root,key);
    }
    TreeNode deleteNodeFromTree(TreeNode root,int key){
        if(root==null)
            return null;
        if(key<root.val){
            root.left=deleteNodeFromTree(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNodeFromTree(root.right,key);
        }
        else{
            if(root.left==null)
                return root.right;
            if(root.right==null)
                return root.left;
            TreeNode temp=findMin(root.right);
            root.val=temp.val;
            root.right=deleteNodeFromTree(root.right,temp.val);
        }
        return root;
    }
    TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
