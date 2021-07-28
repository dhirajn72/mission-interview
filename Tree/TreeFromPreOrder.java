class Solution {
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null || preorder.length==0)
            return 0;
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    TreeNode buildBST(int[] preorder, int min,int max){
        if(index>=preorder.length)
            return null;
        int key=preorder[index];
        TreeNode root=null;
        if(key>min && key<max){
            root=new TreeNode(key);
            index++;
            root.left=buildBST(preorder,min,key);
            root.right=buildBST(preorder,key,max);
        }
        return root;
    }
}
