package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePruning {
	public static TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;

		TreeNode left = pruneTree(root.left);
		TreeNode right = pruneTree(root.right);

		if (root.val == 0 && left == null && right == null)
			return null;
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		System.out.println(pruneTree(root));

		List<Integer> result = new ArrayList<>();
		result.toArray(new int[9][0]);
	}
}
