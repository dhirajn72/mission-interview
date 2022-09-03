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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
            return null;
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums,int low,int high){
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=buildTree(nums, low,mid-1);
        root.right=buildTree(nums,mid+1,high);
        return root;
    }
}
