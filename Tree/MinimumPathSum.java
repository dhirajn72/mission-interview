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
    boolean result=false;
    int target=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return result;
        target=targetSum;
        binaryTreePaths(root);
        return result;
    }
    public void binaryTreePaths(TreeNode root) {
        if(root==null)
            return;
        int[] arr=new int[getSize(root)];
        paths(root,arr,0);
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
    void paths(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            print(arr,i);
        else{
            paths(root.left,arr,i);
            paths(root.right,arr,i);
        }
    }
    void  print(int[] arr,int i){
        int sum=0;
        for(int j=0;j<i;j++){
            sum+=arr[j];
        }
        if(sum==target){
            result=true;
        }
    }
}
