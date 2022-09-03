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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

        ListNode pev=null;
        ListNode temp=list1;
        while(temp!=null){
            if(temp.val==a)
                break;
            prev=temp;
            temp=temp.next;
        }
        last=null;
        temp=list2;
        while(temp!=null){
            if(temp.val==b)
                break;
            temp=temp.next;
        }
        last=temp;

        temp=list1;
        while(temp!=prev){
            temp=temp.next;
        }
        prev.next=list2;
        temp=list2;
        prev=null;
        while(temp!=null){
            prev=temp;
            temp=temp.next;
        }
        prev.next=last;
        return head;
    }
}


