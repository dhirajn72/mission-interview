class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return true;
        if(map.containsKey(k-root.val)){
            return true;
        }
        List<Integer> inOrder=inOrder(root);
        for(int i:inOrder){
            map.put(i,i);
        }
        for(int i:inOrder){
            if(map.containsKey(k-i) && map.get(k-i)!=i)
                return true;
        }
        return false;

    }
    List<Integer> inOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> s=new Stack<>();
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
