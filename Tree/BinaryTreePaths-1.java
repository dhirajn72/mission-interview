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
        int[] arr=new int[1000];
        backtrack(root,arr,0);
        return result;
    }
    void backtrack(TreeNode root,int[] arr,int i){
        if(root==null)
            return;

        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            add(arr,i);
        }
        backtrack(root.left,arr,i);
        backtrack(root.right,arr,i);
    }
    void add(int[] arr,int len){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(arr[i]).append("->");
        }
        sb.setLength(sb.length()-2);
        result.add(sb.toString());
    }
}
