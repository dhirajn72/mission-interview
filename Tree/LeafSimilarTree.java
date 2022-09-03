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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=getLeaves(root1);
        List<Integer> list2=getLeaves(root2);
        if(list1.size()!=list2.size())
            return false;
        int i=0;
        while(i<list1.size() ){
            if(list1.get(i)!=list2.get(i))
                return false;
            i++;
        }
        return true;
    }
    List<Integer> getLeaves(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                if(temp.left==null && temp.right==null)
                    result.add(temp.val);
                root=temp.right;
            }
        }
        return result;
    }
}
