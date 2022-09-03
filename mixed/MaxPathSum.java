class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxPath(root,max);
        return max[0];
    }
    int maxPath(TreeNode root,int[] max){
        if(root==null)
            return 0;
        int left=maxPath(root.left,max);
        int right=maxPath(root.right,max);
        int curr=Math.max(root.val,Math.max(root.val+left,root.val+right));
        max[0]=Math.max(max[0],Math.max(curr,left+root.val+right));
        return curr;
    }
}
