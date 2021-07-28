class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned==null)
            return target;
        Stack<TreeNode> s=new Stack<>();
        s.push(cloned);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(temp.val==target.val)
                    return temp;
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
        return null;
    }
}
