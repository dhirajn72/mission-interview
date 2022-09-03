public class BuildTreePreAndPostOrder {
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		return buildTree(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
	}

	private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft, int postRight) {
		if (preLeft == preRight) return new TreeNode(preorder[preLeft]);

		TreeNode curRoot = new TreeNode(preorder[preLeft]);
		int leftChildIdx = findIdx(postorder, postLeft, postRight, preorder[preLeft + 1]);
		int numOfLeftChild = leftChildIdx - postLeft + 1;

		if (leftChildIdx == (postRight - 1)) {
			// if this node has only one child, then it could be right or left child.
			curRoot.left = buildTree(preorder, preLeft + 1, preRight, postorder, postLeft, postRight - 1);
		} else {
			curRoot.left = buildTree(preorder, preLeft + 1, preLeft + numOfLeftChild, postorder, postLeft, postLeft + numOfLeftChild - 1);
			curRoot.right = buildTree(preorder, preLeft + numOfLeftChild + 1, preRight, postorder, postLeft + numOfLeftChild, postRight - 1);
		}

		return curRoot;
	}

	private int findIdx(int[] postorder, int postLeft, int postRight, int target) {

		for (int i = postLeft; i <= postRight; i++) {
			if (postorder[i] == target) return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		BuildTreePreAndPostOrder obj=new BuildTreePreAndPostOrder();
		int[] pre={1,2,4,5,3,6,7};
		int[] post={4,5,2,6,7,3,1};
		System.out.println(obj.constructFromPrePost(pre,post));
	}
}
