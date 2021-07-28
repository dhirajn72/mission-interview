class Solution {
    List<Double> result=new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return result;
        levelOrder(root);
        return result;
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count=0;
        double sum=0.0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                sum+=temp.val;
                count++;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);

            }
            else{
                result.add(sum/count);
                if(!q.isEmpty())
                    q.offer(null);
                count=0;
                sum=0;
            }
        }
    }
}
