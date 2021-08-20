//This is not corrent implementation of LRU cache. It has bug.
class LRUCache {
    DoublyLinkedList front;
    int max;
    int curr;
    public LRUCache(int capacity) {
        front=new DoublyLinkedList();
        DoublyLinkedList temp=front;
        max=capacity;
        while(capacity!=1){
            DoublyLinkedList node=new DoublyLinkedList();
            temp.rear=node;
            node.front=temp;
            temp=node;
            capacity--;
        } 
    }
    
    public int get(int key) {
        DoublyLinkedList temp=front;
        while(temp!=null){
            if(temp.data[0]==key)
                return temp.data[1];
            temp=temp.rear;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        DoublyLinkedList temp=front;
        if(curr!=max){
           while(temp!=null){
               if(temp.data[0]==Integer.MAX_VALUE){
                   temp.data[0]=key;
                   temp.data[1]=value;
                   curr++;
                   return;
               }
               temp=temp.rear;
           }
       }
       temp=front;
       while(temp.rear!=null){
           temp.data=temp.rear.data;
           temp=temp.rear;
       } 
       temp.data[0]=key;
       temp.data[1]=value;
    } 
    class DoublyLinkedList{
        int[] data;
        DoublyLinkedList front, rear;
        DoublyLinkedList(){
            data=new int[2];
            data[0]=Integer.MAX_VALUE;
            data[1]=Integer.MAX_VALUE;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
