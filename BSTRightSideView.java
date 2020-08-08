public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        return rightView(root);
    }

List<Integer> rightView(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> result=new ArrayList<>();
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
               result.add(list.get(list.size()-1));
               if(!q.isEmpty())
                  q.offer(null);
               list.clear();
            }
        }
        return result;
    }

