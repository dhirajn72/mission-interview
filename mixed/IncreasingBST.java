class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return null;
        List<Integer> inOrder=inOrder(root);
        root=null;
        TreeNode temp=null;
        for(int i:inOrder){
            if(root==null){
                root=new TreeNode(i);
                temp=root;
            }
            else{
                temp.right=new TreeNode(i);
                temp=temp.right;
            }
        }
        return root;
    }
    List<Integer> inOrder(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        List<Integer> result=new ArrayList<>();
        while(!s.isEmpty() || root!=null) {
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
}
