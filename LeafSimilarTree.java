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
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;

        
        List<Integer> bottom1=preOrder(root1);
        List<Integer> bottom2=preOrder(root2);
        if(bottom1.size() != bottom2.size())
            return false;

        for(int i=0;i<bottom1.size();i++){
            if(bottom1.get(i) != bottom2.get(i))
                return false;
        }
        return true;
    }
    List<Integer>  preOrder(TreeNode root){
        if(root==null)
            return null;
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(temp.left==null && temp.right==null)
                    result.add(temp.val);
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
        }
        return result;
    }

}
