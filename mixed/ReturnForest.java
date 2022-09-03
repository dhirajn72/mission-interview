class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result=new ArrayList<>();
        if(root==null)
            return result;
        Set<Integer> toDelete=new HashSet<>();
        for(int i:to_delete)
            toDelete.add(i);
        deleteNode(root,toDelete,result);
        if(!toDelete.contains(root.val))
            result.add(root);
        return result;
    }
    
    TreeNode deleteNode(TreeNode root,Set<Integer> toDelete, List<TreeNode> result){
        
        if(root==null)
            return null;

        root.left=deleteNode(root.left,toDelete, result);
        root.right=deleteNode(root.right,toDelete, result);

        if(toDelete.contains(root.val)){
            if(root.left!=null)
                result.add(root.left);
            if(root.right!=null)
                result.add(root.right);
            return null;
        }
        return root;
    }
}
