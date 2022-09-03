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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        findSum(root,targetSum);
        return result;
    }
    void findSum(TreeNode root,int target){
        if(root==null)
            return;
        int[] arr=new int[1000];
        findPath(root,arr,0,target);
    }
    void findPath(TreeNode root, int[] arr,int i,int target){
        if(root==null)
            return;
            
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            findResult(arr,i,target);
        else{
            findPath(root.left,arr,i,target);
            findPath(root.right,arr,i,target);
        }
    }
    void findResult(int[] arr,int i,int target){
        int sum=0;
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sum+=arr[j];
            sb.append(arr[j]+"->");
        }
        if(sum==target)
            result=true;
    }
}
