class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        return levelOrder(root);
    }
   
    List<Double> levelOrder(TreeNode root){
    	List<Double> result=new ArrayList<>();
    	if(root==null)
    		return result;
    	List<Integer> list=new ArrayList<>();
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
                double average=0.0;
                for(int i:list)
                    average+=i;
                result.add(average/list.size());
    			if(!q.isEmpty())
    				q.offer(null);
    			list.clear();
             }
    	}
    	return result;
   }
}
