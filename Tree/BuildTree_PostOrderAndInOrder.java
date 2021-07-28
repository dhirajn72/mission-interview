class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null && postorder==null)
            return null;
        if(inorder==null || postorder==null)
            return null;
        if(inorder.length!=postorder.length)
            return null;
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode buildTree(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend){
        if(poststart>postend||instart>inend)
            return null;
        int val= postorder[postend];
        TreeNode root=new TreeNode(val);
        int offset=instart;
        for(;offset<inend;offset++){
            if(inorder[offset]==val)
                break;
        }
        root.left=buildTree(postorder,poststart,poststart+offset-instart,inorder,instart,offset-1);
        root.right=buildTree(postorder,poststart+offset-instart+1,postend-1,inorder,offset+1,inend);
        return root;
    }
}
