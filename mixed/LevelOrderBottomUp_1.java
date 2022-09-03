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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       return levelOrder(root);
    }    
    List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        Stack<List<Integer>> stack=new Stack<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                stack.push(new ArrayList<>(list));
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

}
