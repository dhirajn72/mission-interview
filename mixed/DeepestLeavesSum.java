class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)
            return 0;
        return deepestSum(root);
    }
    int deepestSum(TreeNode root){
        if(root==null)
           return 0;
        List<Integer> list=new ArrayList<>();
        int result=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
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
                int sum=0;
                for(int i:list)
                    sum+=i;
                result=sum;
                list.clear();
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return result;
    }
}
