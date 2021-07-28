class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        return bottomUplevelOrder(root);
    }
    List<List<Integer>> bottomUplevelOrder(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        Stack<List<Integer>> s=new Stack<>();
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
                s.push(new ArrayList<>(list));
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        while(!s.isEmpty())
            result.add(s.pop());
        return result;
    }
}
