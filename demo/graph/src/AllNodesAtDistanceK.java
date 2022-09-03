import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesAtDistanceK {
	Map<TreeNode, Integer> map = new HashMap<>();
	List<Integer> result = new ArrayList<>();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		findTarget(root, target);
		dfs(root, target, k, map.get(root));
		return null;
	}
	private void dfs(TreeNode root, TreeNode target, int k, int length) {
		if(root == null) return ;
		if(map.containsKey(root)) length = map.get(root);
		if(length == k) result.add(root.val);
		dfs(root.left, target, k, length + 1);
		dfs(root.right, target, k, length + 1);
	}
	private int findTarget(TreeNode root, TreeNode target) {
		if(root == null) return -1;
		if(root == target) {
			map.put(root, 0);
			return 0;
		}
		int left = findTarget(root.left, target);
		if(left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		int right = findTarget(root.right, target);
		if(right >= 0){
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}
	class TreeNode {
		int val;
		TreeNode left, right;
	}
}
