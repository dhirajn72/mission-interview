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
 // TODO: This is an incomplete solution
class Solution {
    int result=0;
    List<int[]> paths=new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null)
            return result;

        int[] arr=new int[1000];
        paths(root,arr,0);
        for(int[] arr1 : paths){
            permute(arr1,0);
        }
        return result;
    }
    void permute(int[] arr,int i){
        if(arr.length==i){
            if(isPalindrome(arr))
                result++;
        }
        else{
            for(int j=0;j<arr.length;j++){
                swap(arr,i,j);
                permute(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    void path(int[] arr,int i){
        int[] path = new int[i];
        for(int j=0;j<i;j++){
            path[j]= arr[j];
        }
        paths.add(path);
    }
    
    boolean isPalindrome(int[] path){
        int i=0,j=path.length-1;
        while( i <=j ){
            if(!(path[i++]==path[j--]))
                break;
        }
        if(i > j){
            return true;
        }
        return false;
    }
    void paths(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            path(arr,i);
        else{
            paths(root.left,arr,i);
            paths(root.right,arr,i);
        }
    }
}
