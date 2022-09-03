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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null||preorder.length==0)
            return null;
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode buildBST(int[] preorder,int min,int max){
        if(index>=preorder.length)
            return null;
        int val=preorder[index];
        TreeNode root=null;
        if(val>min && val<max){
            root=new TreeNode(val);
            index++;
            root.left=buildBST(preorder,min,val);
            root.right=buildBST(preorder,val,max);
        }
        return root;
    }
}
