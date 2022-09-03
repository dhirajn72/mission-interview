/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Post_InOrder_Tree {
    public TreeNode buildTree(int[] inorder, int[] postOrder) {
    if (postOrder==null||inorder==null||postOrder.length!=inorder.length)return null;
        return _buildTree(postOrder,0,postOrder.length-1,inorder,0,inorder.length-1);

    }

    private static TreeNode _buildTree(int[] postOrder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart>postEnd||inStart>inEnd)return null;
        int data=postOrder[postEnd];
        TreeNode root=new TreeNode(data);
        int offSet=inStart;
        for (; offSet <inEnd ; offSet++) {
            if (inorder[offSet]==data)break;
        }
        root.left=_buildTree(postOrder,postStart,postStart+offSet-inStart-1,inorder,inStart,offSet-1);
        root.right=_buildTree(postOrder,postStart+offSet-inStart,postEnd-1,inorder,offSet+1,inEnd);
        return root;
    }
}