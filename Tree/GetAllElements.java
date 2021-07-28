class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<Integer> s1=allElements(root1);
        Stack<Integer> s2=allElements(root2);
        
        List<Integer> result=new ArrayList<>();
        TreeNode root=null;
        while(!s1.isEmpty()){
            root=insertIntoBST(s1.pop());
        }
        while(!s1.isEmpty()){
            result.add(s1.pop());
        }
        while(!s2.isEmpty()){
            result.add(s2.pop());
        }
        return result;
    }

    Stack<Integer> allElements(TreeNode root){
        if(root==null)
            return new Stack<>();
        Stack<Integer> result=new Stack<>();
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                result.push(temp.val);
                root=temp.right;
            }
        }
        return result;
    }
}
