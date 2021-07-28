class Solution {
    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null || to_delete==null || to_delete.length==0)
            return  result;
        Set<Integer> toDelete=new HashSet<>();
        for(int i:to_delete){
            toDelete.add(i);
        }
        deleteNodes(root,toDelete);
        if(!toDelete.contains(root.val))
            result.add(root);
        return result;
    }
    
    TreeNode deleteNodes(TreeNode root,Set<Integer> toDelete){
        if(root==null)
            return null;
        root.left=deleteNodes(root.left,toDelete);
        root.right=deleteNodes(root.right,toDelete);
        if(toDelete.contains(root.val) ){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;
    }
}


//retryWithExponentialBackOffAndJitter


