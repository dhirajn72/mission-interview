public class Heap_1{

    Node[] arr;
    int curr,max;
    Heap_1(int max){
        arr=new Node[max];
        curr=0;
        this.max=max;
    }
    void insert(int data){
        if(curr==max)
            return;
        Node node=new Node(data);
        arr[curr]=node;
        trickleUp(curr++);
    }
    void trickleUp(int index){
        int parent=(index-1)/2;
        Node bottom=arr[index];
        while(index>0 && arr[parent].data<bottom.data){
            arr[index]=arr[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        arr[index]=bottom;
    }
    int  remove(){
        Node top=arr[0];
        arr[0]=arr[--curr];
        arr[curr]=null;
        trickleDown(0);
        return top.data;
    }
    void trickleDown(int index){
        int largeChild=0;
        Node top=arr[index];
        while(index<curr/2){
            int leftChild=(2*index)+1;
            int rightChild=(2*index)+2;
            if(rightChild<curr && arr[leftChild].data<arr[rightChild].data)
                largeChild=rightChild;
            else
                largeChild=leftChild;

            if(top.data>=arr[largeChild].data)break;
            arr[index]=arr[largeChild];
            index=largeChild;
        }
        arr[index]=top;
    }
    boolean isEmpty(){
        return curr==0;
    }


    class Node{
        int data;
        Node(int data){
            this.data=data;
        }
    }

    public static void main(String[] args){
        int[] arr={5,6,3,7,1,9,4,8,10};
        Heap_1 heap=new Heap_1(arr.length);
        for(int i:arr)
            heap.insert(i);

        while(!heap.isEmpty()){
            System.out.print(heap.remove()+",");
        }
        System.out.println();
    }
}
