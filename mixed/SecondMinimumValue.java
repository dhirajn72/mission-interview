class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return 0;
        Set<Integer> preOrder=new HashSet<>();
        preOrder(root,preOrder);
        int count=0;
        for(int i:preOrder){
            if(count==1)
                return i;
            count++;
        }
    }
    void preOrder(TreeNode root, List<Integer> preOrder){
        if(root!=null){
            preOrder.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
