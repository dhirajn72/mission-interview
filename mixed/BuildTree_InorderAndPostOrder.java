class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null ||postorder.length!=inorder.length)
            return null;
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode buildTree(int[] postorder,int postStart,int postEnd,int[] inorder ,int inStart,int inEnd){
        if(postStart>postEnd||inStart>inEnd)
            return null;
        int data=postorder[postEnd];
        TreeNode root=new TreeNode(data);
        int offset=inStart;
        for(;offset<inEnd;offset++){
            if(inorder[offset]==data)
                break;
        }
        root.left=buidTree(postorder,postStart,postStart+offset-inStart-1,inorder,inStart,offset-1);
        root.right=buidTree(postorder,postStart+offset-inStart,postEnd-1,inorder,offset+1,inEnd);
        return root;
    }
}
