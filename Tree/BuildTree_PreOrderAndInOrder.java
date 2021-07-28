class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null)
            return null;
        if(preorder.length!=inorder.length)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
        if(prestart>preend || instart>inend)
            return null;

        int val = preorder[prestart];
        TreeNode root=new TreeNode(val);
        int offset=instart;
        for(;offset<inend;offset++){
            if(inorder[offset]==val)
                break;
        }

        root.left=buildTree(preorder,prestart+1,prestart+offset-instart,inorder,instart,offset-1);
        root.right=buildTree(preorder,prestart+offset-instart+1,preend,inorder,offset+1,inend);
        return root;
    }
}
