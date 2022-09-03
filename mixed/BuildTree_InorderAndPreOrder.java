class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null ||inorder==null || preorder.length!=inorder.length)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder, int inStart,int inEnd){
        if(preStart>preEnd || inStart>inEnd)
            return null;
        int data=preorder[preStart];
        TreeNode root=new TreeNode(data);
        int offset=inStart;
        for(;offset<inEnd;offset++){
            if(inorder[offset]==data)
                break;
        }
        root.left=buildTree(preorder,preStart+1,preStart+offset-inStart,inorder,inStart,offset-1);
        root.right=buildTree(preorder,preStart+offset-inStart+1,preEnd,inorder,offset+1,inEnd);
        return root;
    }
}
