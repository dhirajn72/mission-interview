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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        List<ListNode> lesser=new ArrayList<>();
        List<ListNode> greater=new ArrayList<>();
        ListNode temp=head;
        ListNode prev=head;
        while(temp!=null){
            prev=temp;
            if(temp.val<x){
                lesser.add(temp);
            }
            else{
                greater.add(temp);
            }
            temp=temp.next;
            prev.next=null;
        }
        head=new ListNode(0);
        temp=head;
        for(ListNode node:lesser){
            temp.next=node;
            temp=temp.next;
        }
        for(ListNode node:greater){
            temp.next=node;
            temp=temp.next;
        }
        return head.next;
    }
}
