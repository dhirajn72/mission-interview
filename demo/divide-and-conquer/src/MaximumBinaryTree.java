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
public class MaximumBinaryTree{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums,int low,int high){
        if(low>high)
            return null;
        int mid=low,max=Integer.MIN_VALUE;
        for(int i=low;i<=high;i++){
            if(nums[i]>max){
                max=nums[i];
                mid=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(nums,low,mid-1);
        root.right=buildTree(nums,mid+1,high);
        return root;
    }
}
