class Solution {
    int sum=0;
    Stack<Integer> s=new Stack<>();
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            sum+=root.left;
        } 
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
