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
class CBTInserter {

    TreeNode root=null;
    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int v) {
        if(root==null){
            root=new TreeNode(v);
            return root.val;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int parent=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                parent=temp.val;
                if(temp.left!=null)
                    q.offer(temp.left);
        
                if(temp.right!=null)
                    q.offer(temp.right);

                if(temp.left==null){
                    temp.left=new TreeNode(v);
                    break;
                }
                if(temp.right==null){
                    temp.right=new TreeNode(v);
                    break;
                }
            }
        }
        return parent;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
