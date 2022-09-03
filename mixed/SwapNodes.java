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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode tempNext=head.next.next;
        ListNode tempSecond=head.next;
        ListNode tempFirst=head;

        head=tempSecond;
        head.next=tempFirst;
        head.next.next=swapPairs(tempNext);
        return head;
    }
}
