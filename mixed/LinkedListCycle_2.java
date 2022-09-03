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

        ListNode slowPtr=head;
        ListNode fastPtr=head;
        boolean isCycle=false;
        while(fastPtr !=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
            if(slowPtr==fastPtr){
                isCycle=true;
                break;
            }
        }
        if(isCycle){
           fastPtr=head;
           while(fastPtr!=slowPtr){
               slowPtr=slowPtr.next;
               fastPtr=fastPtr.next;
           }
           return fastPtr;
        }
        if(!isCycle)
            return null;
        return head;
    }
}
