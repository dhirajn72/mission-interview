public int kthSmallest(TreeNode root, int k) {
     if(root==null)
          return -1;
     List<Integer> inOrder=getInorder(root);
     if(inOrder.size()>=k)
          return inOrder.get(k-1);
     return -1;
    }
List<Integer> getInorder(TreeNode root){
     if(root==null)
          return new ArrayList<>();
     Stack<TreeNode> s=new Stack<>();
     List<Inreger> result=new ArrayList<>();
     while(!s.isEmpty()||root!=null){
          if(root!=null){
               s.push(root);
               root=root.left;
          }
          else{
               TreeNode temp=s.pop();
               result.add(temp.val);
               root=temp.right;
          }
     }
     return result;
}
