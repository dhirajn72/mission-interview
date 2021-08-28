/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;

        if(head.next==null)
            return null;
        ListNode slowPtr=head;
        ListNode fastPtr=head;

        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr){
                break;
            }
        }
        if(fastPtr==null || fastPtr.next==null)
            return null;
        fastPtr=head;
        while(fastPtr!=slowPtr){
            fastPtr=fastPtr.next;
            slowPtr=slowPtr.next;
        }
        return slowPtr;
    }
}
