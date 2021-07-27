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
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null)
            return result;
        Set<Integer> set=new HashSet<>();
        for(int e:to_delete)
            set.add(e);
        deleteNodes(root,set);
        if(!set.contains(root.val)){
            result.add(root);
        }
        return result;
    }
    TreeNode deleteNodes(TreeNode root, Set<Integer> set){
        if(root==null)
            return root;
        root.left=deleteNodes(root.left,set);
        root.right=deleteNodes(root.right,set);
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
