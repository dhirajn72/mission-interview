public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return result;
        dfs(root,new ArrayList<>(),sum);
        return result;
    }
    void dfs(TreeNode root,List<Integer> list,int sum){
        if(root==null)
            return ;

        list.add(root.val);
        if(root.left==null && root.right==null){
            if(root.val==sum){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if(root.left!=null){
            dfs(root.left,list,sum-root.val);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            dfs(root.right,list,sum-root.val);
            list.remove(list.size()-1);
        }
    }
}
