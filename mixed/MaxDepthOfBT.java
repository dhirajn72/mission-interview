
public class Solution{
    int max=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            if(temp!=null){
                 if(temp.left!=null)
                     q.offer(temp.left);
                 if(temp.right!=null)
                     q.offer(temp.right);
            }
            else{
                max++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return max;
    }
}

