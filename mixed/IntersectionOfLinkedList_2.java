

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA=length(headA);
        int lenB=length(headB);
        
        while(lenA<lenB){
            headB=headB.next;
            lenB--;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }
    
    int length(ListNode head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}

