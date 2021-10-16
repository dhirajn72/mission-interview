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
//TODO: This is buggy code leetcode 652
class Solution {
    List<TreeNode> result=new ArrayList<>();
    Set<String> set=new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root==null)
            return result;
        int[] arr=new int[1000 /*getSize(root)*/];
        findDuplicateSubtrees(root,arr,0);
        findDuplicateSubtrees(root.left);
        findDuplicateSubtrees(root.right);
        return result;
    }
    void findDuplicateSubtrees(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
           boolean isDuplicate= addToResult(arr,i);
           if(isDuplicate){
                result.add(root);
            }
        }
        else{
            findDuplicateSubtrees(root.left,arr,i+1);
            findDuplicateSubtrees(root.right,arr,i+1);
        }
    }
    boolean addToResult(int[] arr,int l){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l;i++){
            sb.append(arr[i]);
        }
        if(set.contains(sb.toString())){
            return true;
        }
        else{
            set.add(sb.toString());
        }
        return false;
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
