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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode > result=new ArrayList<>();
        if(n==1){
            TreeNode root=new TreeNode(0);
            result.add(root);
            return result;
        }
        else{
            for(int i=1;i<n;i+=2){
                List<TreeNode> leftSubTrees=allPossibleFBT(i);
                List<TreeNode> rightSubTrees=allPossibleFBT(n-i-1);
                for(TreeNode l:leftSubTrees){
                    for(TreeNode r:rightSubTrees){
                        TreeNode root=new TreeNode(0);
                        root.left=l;
                        root.right=r;
                        result.add(root);
                    }
                }
            }
        }
        return result;
        
    }
}
