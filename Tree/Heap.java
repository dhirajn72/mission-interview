public class Heap{
    Node[] arr;
    int curr,max;
    
    public Heap(int max){
        this.max=max;
        arr=new Node[max];
        curr=0;
    }
    void insert(int data){
        if(curr==max)
            return ;
        Node node =new Node(data);
        arr[curr]=node;
        trickleUp(curr++);
    }
    void trickleUp(int index){
        int parent=(index-1)/2;
        Node bottom=arr[index];
        while(index>0 && arr[parent].val>bottom.val){
            arr[index]=arr[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        arr[index]=bottom;
    }

    int remove(){
        if(curr==0)
            return -1;
        Node top=arr[0];
        arr[0]=arr[--curr];
        arr[curr]=null;
        trickleDown(0);
        return top.val;
    }
    void trickleDown(int index){
       int largeChild=0;
       Node top=arr[index];
       while(index<curr/2){
           int leftChild=(2*index)+1;
           int rightChild=(2*index)+2;
           if(rightChild<curr && arr[leftChild].val>arr[rightChild].val)
               largeChild=rightChild;
           else
               largeChild=leftChild;
           if(top.val<=arr[largeChild].val) break;
           arr[index]=arr[largeChild];
           index=largeChild;
        }
        arr[index]=top;
    }
    boolean isEmpty(){
        return curr==0;
    }
    public static void main(String[] args){
        int[] arr={9,2,4,1,3,6,5,7};
        Heap heap=new Heap(arr.length);
        for(int i:arr)
            heap.insert(i);
        while(!heap.isEmpty()){
            System.out.print(heap.remove()+",");
        }
        System.out.println();
    }


    class Node{
        int val;
       public Node(int val){
           this.val=val;
       }
    }
}
