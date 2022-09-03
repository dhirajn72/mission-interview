package tree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfTree {
	static public int widthOfBinaryTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return dfs(root, 0, 1, list);
	}
	static int dfs(TreeNode root, int level, int id, List<Integer> list) {
		if (root == null) return 0;
		if (level == list.size())
			list.add(id);
		int curr = id - list.get(level) + 1;
		int left = dfs(root.left, level + 1, 2 * id, list);
		int right = dfs(root.right, level + 1, 2 * id + 1, list);
		return Math.max(curr, Math.max(left, right));
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		int result = widthOfBinaryTree(root);
		System.out.println(result);
		System.out.println("-------");
	}

}
