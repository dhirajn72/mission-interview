class MyLinkedList {
    ListNode head;

    public MyLinkedList() {
    }
    
    public int get(int index) {
        int count=0;
        ListNode temp=head;
        while(count!=index){
            temp=temp.next;
        }
        return temp.val;
        
    }
    
    public void addAtHead(int val) {
        if(head==null){
            head=new ListNode(val);
            return ;
        }
        ListNode node=new ListNode(val);
        node.next=head.next;
        head.next=node;
    }
    
    public void addAtTail(int val) {
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new ListNode(val);
    }
    
    public void addAtIndex(int index, int val) {
        int count=0;
        ListNode temp=head;
        ListNode prev=null;
        while(count!=index){
            prev=temp;
            temp=temp.next;
            count++;
            if(count==index){
                ListNode node=new ListNode(val);
                node.next=temp;
                prev.next=node;
                break;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        int count=0;
        ListNode temp=head;
        ListNode pre=null;
        while(index!=count){
            prev=temp;
            temp=temp.next;
            count++;
        }
        if(prev.next!=null)
            prev.next=prev.next.next;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
