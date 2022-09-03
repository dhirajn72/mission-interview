class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        List<Integer> l1=getLastLevel(root1);
        List<Integer> l2=getLastLevel(root2);
        if(l1.size()!= l2.size())
            return false;
        System.out.println(l1);
        System.out.println(l2);
        int index=0;
        while(index < l1.size() && l1.get(index)==l2.get(index) ){
            index++;
        }
        return index>=l1.size()?true:false;
    }
    List<Integer> getLastLevel(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        List<Integer> list=new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(temp.left==null && temp.right==null)
                    list.add(temp.val);
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
        }
        return list;
    }
}
