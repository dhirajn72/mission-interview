import java.util.*;

public class Solution {
    boolean result=false;
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer> map=new HashMap();
        findTargetSum(root,map,k);
        return result;
    }
    void findTargetSum(TreeNode root, Map<Integer> map,int k){
        if(root!=null){
            int val=root.val;
            if(map.containsKey(k-val)){
                result=true;
                return;
            }
            if(!result)
                findTargetSum(root.left,map,k);
            if(!result)
                findTargetSum(root.right,map,k);
        }
    }
    public static void main(String[] args) {
        Solution s=new Solution();
    }

    class TreeNode{
        int val;
        TreeNode left, right;
    }
}