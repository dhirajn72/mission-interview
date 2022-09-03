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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null)
            return null;
        return buildTree(nums,0,nums.length-1);
        
    }

    TreeNode buildTree(int[] arr,int low, int high){
        if(low>high)
            return null;
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=low;i<=high;i++){
            if(max<arr[i]){
                max=arr[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(arr,low,index-1);
        root.right=buildTree(arr,index+1,high);
        return root;
    }
}
