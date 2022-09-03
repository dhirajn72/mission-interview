
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        ListNode temp=node;
        ListNode prev=null;
        while(temp!=null && temp.next!=null){
            temp.val=temp.next.val;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;

    }
}


