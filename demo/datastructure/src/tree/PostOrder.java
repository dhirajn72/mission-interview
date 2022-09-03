package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
	static List<Integer>  postOrder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> valStack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode temp = stack.pop();
			if(temp != null){
				valStack.push(temp.val);
				if(temp.left  != null)
					stack.push(temp.left);
				if (temp.right != null)
					stack.push(temp.right);
			}
		}
		while(!valStack.isEmpty())
			result.add(valStack.pop());
		return result;
	}
	static  void  postOrderRecursive(TreeNode root){
		if(root != null){
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.print(root.val+",");
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(postOrder(root));
		postOrderRecursive(root);

	}
}
