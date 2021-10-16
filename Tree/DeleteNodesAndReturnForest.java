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
    Set<Integer> delNodes=new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null)
            return result;
        for(int e:to_delete){
            delNodes.add(e);
        }
        deleteNodes(root);
        if(!delNodes.contains(root.val)){
            result.add(root);
        }
        return result;
    }
    TreeNode deleteNodes(TreeNode root){
        if(root==null)
            return null;
        root.left=deleteNodes(root.left);
        root.right=deleteNodes(root.right);
        if( delNodes.contains(root.val)){
            if(root.left!=null){
                result.add(root.left);
            }
            if(root.right!=null){
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}

