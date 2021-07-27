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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
             return head;
        boolean flag=true;
        ListNode oddList=new ListNode(0);
        ListNode evenList=new ListNode(0);
        ListNode temp=head;
        ListNode oddTemp=oddList;
        ListNode evenTemp=evenList;
        while(temp!=null){
            if(flag){
                oddTemp.next=new ListNode(temp.val);
                flag=false;
                oddTemp=oddTemp.next;
            }
            else{
                evenTemp.next=new ListNode(temp.val);
                flag=true;
                evenTemp=evenTemp.next;
            }
            temp=temp.next;
        }
        oddTemp.next=evenList.next;
        return oddList.next;
    }
}
