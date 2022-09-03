
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
            return true;
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null && temp.val==stack.peek()){
            temp=temp.next;
            stack.pop();
        }
        if(temp==null && stack.isEmpty())
            return true;
        return false;
    }
}






