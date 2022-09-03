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
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        int size=getSize(head);
        int[] arr=new int[size];
        ListNode temp=head;
        int index=0;
        while(temp!=null){
            arr[index++]=temp.val;
            temp=temp.next;
        }

        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int min=arr[i];
            while(j>=0 && min<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=min;
        }
        temp=head;
        for(int e:arr){
            temp.val=e;
            temp=temp.next;
        }
        return head;

    }
    int getSize(ListNode head){
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}
