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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return result;
        int[] arr=new int[10000];
        findPaths(root,arr,0,targetSum);
        return result;
    }
    void findPaths(TreeNode root,int[] arr,int  i,int targetSum){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            addToResult(arr,i,targetSum);
        }
        else{
            findPaths(root.left,arr,i,targetSum);
            findPaths(root.right,arr,i,targetSum);
        }
    }
    void addToResult(int[] arr,int i,int targetSum){
        int sum=0;
        List<Integer> list=new ArrayList<>();
        for(int j=0;j<i;j++){
            sum+=arr[j];
            list.add(arr[j]);
        }
        if(sum==targetSum)
            result.add(list);
    }
}
