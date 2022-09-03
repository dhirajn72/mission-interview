import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceBinarySearchTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	static public TreeNode balanceBST(TreeNode root) {
		if (root == null)
			return null;
		int[] inorder = inorder(root);
		return buildTree(inorder, 0, inorder.length - 1);
	}

	static TreeNode buildTree(int[] nums, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = buildTree(nums, low, mid - 1);
			root.right = buildTree(nums, mid + 1, high);
			return root;
		}
		return null;
	}

	static int[] inorder(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode temp = stack.pop();
				list.add(temp.val);
				root = temp.right;
			}
		}
		int[] result = new int[list.size()];
		int index = 0;
		for (int e : list) {
			result[index++] = e;
		}
		return result;
	}
}
