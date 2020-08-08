class Solution {
    int max=0;
    Map<TreeNode,Boolean> dp=new HashMap<>();
    public int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        if(isBST(root)){
            max=Math.max(max,findSum(root));
        }
        maxSumBST(root.left);
        maxSumBST(root.right);
        return max;
    }
    boolean isBST(TreeNode root){
        if(root==null)
            return true;
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isBST(TreeNode root, int min,int max){
        if(dp.containsKey(root))
            return dp.get(root);
        if(root==null)
            return true;
        boolean left=isBST(root.left,min,root.val);
        map.put(root.left,left);
        boolean rigth=isBST(root.right,root.val,max);
        map.put(root.right,right);
        return root.val>min && root.val<max && left && right; 
    }

    int findSum(TreeNode root){
        if(root==null)
            return 0;
        int sum=root.val;
        sum+=findSum(root.left);
        sum+=findSum(root.right);
        return sum;
    }
}
