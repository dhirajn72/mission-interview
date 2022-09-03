public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result=new ArrayList<>();
	if(root==null)
		return result;
	List<Integer> list=new ArrayList<>();
   	Queue<TreeNode> q=new Stack<>();
   	q.push(root);
	q.offer(null);
   	while(!s.isEmpty()){
         TreeNode temp = q.pop();   
         if(temp!=null){
            list.add(temp.val);
            if(temp.left!=null)
               q.offer(temp.left);
            if(temp.right!=null)
               q.offer(temp.right);
         }
         else{
			result.add(new ArrayList<>(list));
			if(!q.isEmpty();
				q.offer(null);
			list.clear();
         }
	}
	return result;
   }
