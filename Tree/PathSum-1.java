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
        dfs(root,new ArrayList<>(),targetSum);
        return result;
    }
    void dfs(TreeNode root,List<Integer> list,int target){
        if(root==null)
            return ;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==target)
                result.add(new  ArrayList<>(list));
        }
        if(root.left!=null){
            dfs(root.left,list,target-root.val);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,list,target-root.val);
            list.remove(list.size()-1);
        }
    }
}
