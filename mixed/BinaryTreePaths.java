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
    List<String> result=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return result;
        int size=getSize(root);
        int[] arr=new int[size];
        findPaths(root,arr,0);
        return result;    
    }
    void findPaths(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            addResult(arr,i);
        }
        else{
            findPaths(root.left,arr,i);
            findPaths(root.right,arr,i);
        }
    }
    void addResult(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]).append("->");
        }
        result.add(sb.delete(sb.length()-2,sb.length()).toString());
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
}
