class Solution {
    public int minDiffInBST(TreeNode root) {
        if(root==null)
            return 0;
        List<Integer> inOrder=inOrder(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<inOrder.size();i++){
            min=Math.min(min,inOrder.get(i)-inOrder.get(i-1));
        }
        return min;
    }

    public  List<Integer> inOrder(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        List<Integer> result=new ArrayList<>(); 
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
}
