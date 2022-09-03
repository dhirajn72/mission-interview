class Solution{
    public String tree2str(TreeNode t) {
     //   return t==null ? "" :
      //      t.val + ( t.left!=null ? "(" + tree2str(t.left)+")" : t.right!=null ? "()":"" )+
       //     (t.right!=null ? "("+ tree2str(t.right) +" )" :"" );

        if(root==null)
            return null;
        return buildString(t).toString();
    }
    StringBuilder buildString(TreeNode root){
        if(root==null)
            return null;

        StringBuilder sb=new StringBuilder();
        sb.append(root.val);

        StringBuilder left=buildString(root.left);
        StringBuilder right=buildString(root.right);

        if(left==null && right==null)
            return sb;
        
        sb.append("(").append(left==null ? "" :left).append(")");
        if(right!=null )
            sb.append("(").append(right).append(")");
        return sb;
        
    }
}
