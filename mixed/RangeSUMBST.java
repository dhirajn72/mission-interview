class Solution {
    int result=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null)
            return result;
        if(root.val>=L && root.val<=R)
            result+=root.val;
        rangeSumBST(root.left,L,R);
        rangeSumBST(root.right,L,R);
        return result;
    }
}
