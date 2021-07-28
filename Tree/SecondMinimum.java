class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        List<Intege> list=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
        Collections.sort(list);
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int i:list){
            set.add(i);
            if(count==1)
                return i;
        }
        return -1;
    }
}
