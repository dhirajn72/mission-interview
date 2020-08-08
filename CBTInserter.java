import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;





//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class CBTInserter {
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int v) {
        if(root==null){
            root=new TreeNode(v);
            return v;
        }
        TreeNode val= insert(root,v);
        return val.val;
    }
    TreeNode insert(TreeNode root,int v){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode res=root;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left==null){
                    temp.left=new TreeNode(v);
                    break;
                }
                else if(temp.right==null){
                    temp.right=new TreeNode(v);
                    break;
                }
                else{
                    res=temp;
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
        }
        return res;
    }
    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        CBTInserter obj=new CBTInserter(root);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
        obj.insert(6);
        obj.insert(7);
        obj.insert(8);
        obj.levelOrderTraversal(root);
    }

    public void levelOrderTraversal(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                result.add(new ArrayList<>(list));
                list.clear();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        System.out.println(result);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */