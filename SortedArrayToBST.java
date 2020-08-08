class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
            return null;
        return buildBST(nums,0,nums.length-1);        
    }

    TreeNode buildBST(int[] arr, int min, int max){
        if(min>max)
            return null;
        int mid=(min+max)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=buildBST(arr,min,mid-1);
        root.right=buildBST(arr,mid+1,max);
        return root;
    }
}
