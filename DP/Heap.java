public class Heap{
    
    Node[] arr;
    int curr,max;

    Heap(int max){
        this.max=max;
        arr=new Node[max];
    }

    void insert(int data){
        if(max==curr)
            return;
        Node node=new Node(data);
        arr[curr]=node;
        trickleUp(curr++);
    }

    void trickleUp(int index){
        int parent=(index-1)/2;
        Node bottom=arr[index];
        while(index>0 && arr[parent].data>bottom.data){
            arr[index]=arr[parent];
            index=parent;
            parent=(parent-1)/2;
        }
        arr[index]=bottom;
    }

    int remove(){
        if(curr==0)
            return Integer.MIN_VALUE;
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
            if(rightChild<curr && arr[leftChild].data>arr[rightChild].data)
                largeChild=rightChild;
            else
                largeChild=leftChild;

            if(top.data<=arr[largeChild].data)break;
            arr[index]=arr[largeChild];
            index=largeChild;
        }
        arr[index]=top;
    }
    int getCurrent(){
        return curr;
    }

    public static void main(String[] args){
        int[] arr={6,1,2,3,8,5,4,3};
        Heap heap=new Heap(arr.length);
        for(int i:arr){
            heap.insert(i);
        }

        while(heap.getCurrent()!=0){
            System.out.print(heap.remove()+",");
        }
            System.out.println();
    }

    class Node{
        int data;
        Node(int data){
            this.data=data;
        }
    }
}
