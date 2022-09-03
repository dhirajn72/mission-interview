import java.util.ArrayList;
import java.util.List;

public class GenerateTree {
    public static void main(String[] args){
        System.out.println(generateTree(3));
    }

    static List<TreeNode> generateTree(int n){
        if(n==0)
            return new ArrayList<>();
        return generate(1,n);
    }
    static List<TreeNode> generate(int m,int n){
        List<TreeNode> result=new ArrayList<>();
        if(m>n){
            result.add(null);
            return result;
        }
        for(int i=m;i<=n;i++){
            List<TreeNode> left=generate(m,i-1);
            List<TreeNode> right=generate(i+1,n);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode curr=new TreeNode(i);
                    curr.left=l;
                    curr.right=r;
                    result.add(curr);
                }
            }
        }
        return result;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.val=data;
            this.left=null;
            this.right=null;
        }
        public String toString(){
            return "List["+val+",left"+left+",right"+right+"]";
        }
    }
}
