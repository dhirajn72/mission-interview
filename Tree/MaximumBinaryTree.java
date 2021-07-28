class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0) 
            return null;
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums,int low,int high){
        if(low>high)
            return null;
        int max=Integer.MIN_VALUE,index=-1;
        for(int i=low;i<=high;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(nums,low,index-1);
        root.right=buildTree(nums,index+1,high);
        return root;
    }
}
