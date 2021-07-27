

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return 0;
        int[] arr=new int[getSize(root)];
        inorderTraversal(root,arr);
        return arr[k-1];
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
    public void inorderTraversal(TreeNode root,int[] arr) {
         if(root==null)
             return ;
         Stack<TreeNode> s=new Stack();
         int index=0;
         while(!s.isEmpty() || root!=null){
             if(root!=null){
                 s.push(root);
                 root=root.left;
             }
             else{
                 TreeNode temp=s.pop();
                 arr[index++]=temp.val;
                 root=temp.right;
             }
         }
    }

}


