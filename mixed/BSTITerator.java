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
class BSTIterator {
    Queue<Integer> q=null;
    public BSTIterator(TreeNode root) {   
        q=new LinkedList<>();
        inorderTraversal(root);
    }
    
    void inorderTraversal(TreeNode root){
        Stack<TreeNode> s=new Stack();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                q.offer(temp.val);
                root=temp.right;
            }
        }
    }
    public int next() {
        if(q!=null && !q.isEmpty())
            return q.poll();
        return 0;
    }
    
    public boolean hasNext() {
        return q!=null && !q.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
