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
    List<Integer> paths=new LinkedList<>();
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        int[] arr=new int[getSize(root)];

        paths(root,arr,0);
        int result=0;
        for(int val:paths)
            result+=val;
        return result;
        
    }
    void paths(TreeNode root,int[] arr,int i){
        if(root==null)
            return;
            
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            addToList(arr,i);
        }
        else{
            paths(root.left,arr,i);
            paths(root.right,arr,i);
        }
    }

    void addToList(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]);
        }
        paths.add(Integer.parseInt(sb.toString()));
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

