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
    Set<Integer> set=new HashSet<>();    
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null)
            return new ArrayList<>();
        for(int val:to_delete){
            set.add(val);
        }
        deleteNodes(root);
        if(!set.contains(root.val)){
            result.add(root);
        }
        return result; 
    }
    TreeNode deleteNodes(TreeNode root){
        if(root==null)
            return null;
        root.left=deleteNodes(root.left);
        root.right=deleteNodes(root.right);
        if(set.contains(root.val)){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;
    }
}
