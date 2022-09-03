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
        int[] arr=new int[getSize(root)];
        treePaths(root,arr,0);
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
    void treePaths(TreeNode root, int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            addToResult(arr,i);
        }
        else{
            treePaths(root.left,arr,i);
            treePaths(root.right,arr,i);
        }
    }
    void addToResult(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]).append("->");
        }
        sb.deleteCharAt(sb.length()-2,sb.length());
        result.add(sb.toString());
    }
}
