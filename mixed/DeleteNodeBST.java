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
            return root;
        if(key<root.val)
            root.left=deleteNode(root.left,key);
        else if(key>root.val)
            root.right=deleteNode(root.right,key);
        else{
            if(root.left==null)
                return root.right;
            else
                return root.left;
            TreeNode temp=findMin(root.right);
            root.val=temp.val;
            root.right=deleteNode(root.right,temp.val);
        }
        return root;
    }
    TreeNode findMin(TreeNode root){
        while(root.left!=null)
            root=root.left;
        return root;
    }
}
