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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        Set<Integer> set=new LinkedHashSet<>();
        ListNode temp=head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        ListNode prev=null;
        for(int e:set){
            temp.val=e;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return head;
    }
}
