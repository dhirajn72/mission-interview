public List<Integer> preorderTraversal(TreeNode root) {
	if(root==null){
		return null;
	}
	List<Integer> result=new ArrayList<>();
	Stack<TreeNode> s=new Stack<>();
	s.push(root);
     while(!s.isEmpty()){
          TreeNode temp=s.pop();
          if(temp!=null){
               result.add(temp.val);
               if(temp.right!=null)
                    s.push(temp.right);
               if(temp.left!=null)
                    s.push(temp.left);
               }

          }
     return result;
    }
