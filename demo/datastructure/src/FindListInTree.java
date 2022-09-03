import tree.TreeNode;

public class FindListInTree {
	static public boolean isSubPath(ListNode head, TreeNode root) {
		if(root == null && head == null)
			return true;
		if(root == null || head == null)
			return false;

		if(head.val == root.val || isSubPath(head, root.left) || isSubPath(head, root.right)){
			return isSubPath(head.next, root.left) || isSubPath(head.next, root.right);
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(6);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(1);
		root.right.left.right.right = new TreeNode(3);
		System.out.println(isSubPath(head, root));
	}
}
