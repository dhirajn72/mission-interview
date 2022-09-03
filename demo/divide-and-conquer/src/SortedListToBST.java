public class SortedListToBST {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head==null)
                return null;
            int[] nums=getElements(head);
            return buildTree(nums,0,nums.length-1);
        }
        TreeNode buildTree(int[] nums,int low,int high){
            if(low>high)
                return null;
            int mid=(low+high)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=buildTree(nums,low,mid-1);
            root.right=buildTree(nums,mid+1,high);
            return root;

        }
        int[] getElements(ListNode head){
            int size=getSize(head);
            int[] result=new int[size];
            int index=0;
            ListNode temp=head;
            while(temp!=null){
                result[index++]=temp.val;
                temp=temp.next;
            }
            return result;
        }
        int getSize(ListNode head){
            if(head==null)
                return 0;
            int size=1;
            size+=getSize(head.next);
            return size;
        }
    }
}
