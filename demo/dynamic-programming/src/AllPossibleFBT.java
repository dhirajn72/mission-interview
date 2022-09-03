import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFBT {
	static Map<Integer, List<TreeNode>> dp = new HashMap<>();
	static public List<TreeNode> allPossibleFBT(int n) {
		if(n == 0 || n % 2 == 0){
			return new ArrayList<>();
		}
		return buildTree(n);
	}
	static List<TreeNode> buildTree(int n){
		if(dp.containsKey(n))
			return dp.get(n);

		List<TreeNode> list = new ArrayList<>();
		if(n == 1){
			list.add(new TreeNode(0));
		}
		else{
			for(int i = 1; i < n ; i += 2){
				List<TreeNode> leftTrees = buildTree(i);
				dp.put(i, leftTrees);
				List<TreeNode> rightTrees = buildTree(n - i - 1);
				for(TreeNode left : leftTrees){
					for(TreeNode right : rightTrees){
						TreeNode root = new TreeNode(0);
						root.left = left;
						root.right = right;
						list.add(root);
					}
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(allPossibleFBT(5));
	}
}
