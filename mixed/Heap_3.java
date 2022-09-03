public class Heap_3{
    private Node[] arr;
    private int max;
    private int curr;

    public static void main(String[] args){
        int[] arr={8,7,6,5,3,4,1,2};
        Heap_3 heap=new Heap_3(arr.length);
        for(int e:arr){
            heap.insert(e);
        }
        while(heap.curr!=0){
            System.out.print(heap.remove()+",");
        }

    }
    public Heap_3(int max){
        this.max=max;
        this.arr=new Node[max];
    }
    public void insert(int e){
        if(curr==max){
            System.out.print("Heap is full !");
            return;
        }
        Node node =new Node(e);
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
        if(curr==0){
            System.out.print("Heap is empty !");
            return -1;
        }
        Node top=arr[0];
        arr[0]=arr[--curr];
        trickleDown(0);
        return top.data;
    }
    void trickleDown(int index){
        int largeChild=0;
        Node top=arr[index];
        while(index<curr/2){
            int leftChild=(2*index)+1;
            int rightChild=(2*index)+2;
            if(rightChild<curr && arr[leftChild].data > arr[rightChild].data)
                largeChild=rightChild;
            else
                largeChild=leftChild;

            if(top.data<=arr[largeChild].data)break;
            arr[index]=arr[largeChild];
            index=largeChild;
        }
        arr[index]=top;
    }
    class Node{
        int data;
        public Node(int data){
            this.data=data;
        }
    }
}
