import javafx.util.Pair;
import tree.TreeNode;

import java.util.Set;
import java.util.TreeSet;

public class PreorderAndInorder {
	static public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null && inorder==null)
			return null;
		if(preorder==null || inorder==null)
			return null;
		if(preorder.length!=inorder.length)
			return null;
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	static TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend){
		if(prestart>preend || instart>inend)
			return null;

		int val=preorder[prestart];
		int offset=instart;
		for(;offset<inend;offset++){
			if(inorder[offset]==val)
				break;
		}
		TreeNode root=new TreeNode(val);
		root.left=buildTree(preorder,prestart+1,prestart+offset-instart,inorder,instart,offset-1);
		root.right=buildTree(preorder,prestart+offset-instart+1,preend,inorder,offset+1,inend);
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7 }, inorder = {9,3,15,20,7};
		System.out.println(buildTree(preorder, inorder));

	}
}
