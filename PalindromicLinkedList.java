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
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;

        Stack<Integer> s=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            s.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null && !s.isEmpty()){
            if(temp.val==s.peek()){
                temp=temp.next;
                s.pop();
            }
            else{
                return false;
            }
        }
        return true;
    }
}
