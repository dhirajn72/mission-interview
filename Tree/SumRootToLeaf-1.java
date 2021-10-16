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
    int result=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return result;
        int[] arr=new int[getSize(root)];
        findRootToLeafSum(root,arr,0);
        return result;
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
    void findRootToLeafSum(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
           addToResult(arr,i);
        }
        else{
            findRootToLeafSum(root.left,arr,i);
            findRootToLeafSum(root.right,arr,i);
        }
    }
    void addToResult(int[] arr,int l){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l;i++){
            sb.append(arr[i]);
        }
        result+=Integer.valueOf(sb.toString());
    }
}
