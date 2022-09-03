/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pre_InOrder_Tree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder==null||inorder==null||preorder.length!=inorder.length)return null;
        return _buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }

    private static TreeNode _buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd||inStart>inEnd)return null;
        int data=preorder[preStart];
        TreeNode root=new TreeNode(data);
        int offSet=inStart;
        for (; offSet <inEnd ; offSet++) {
            if (inorder[offSet]==data)break;
        }
        root.left=_buildTree(preorder,preStart+1,preStart+offSet-inStart,inorder,inStart,offSet-1);
        root.right=_buildTree(preorder,preStart+offSet-inStart+1,preEnd,inorder,offSet+1,inEnd);
        return root;
    }
}
